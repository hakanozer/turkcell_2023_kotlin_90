package com.ao.productsapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ao.productsapp.configs.ApiClient
import com.ao.productsapp.databinding.ActivityProductBinding
import com.ao.productsapp.model.Product
import com.ao.productsapp.model.Products
import com.ao.productsapp.services.DummyService

import com.ao.productsapp.ui.adapter.ProductAdapter
import com.ao.productsapp.utils.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity() {
    lateinit var dummyService: DummyService
    private lateinit var binding:ActivityProductBinding
    var productList = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarProduct.title = "Products"
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        binding.recyclerViewProduct.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)




        getProducts()


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    searchProducts(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    getProducts()
                }
                return true
            }

        })

    }

    private fun getProducts() {
        dummyService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful()) {
                    response.body()?.let {
                        productList = it.products as MutableList<Product>
                        binding.recyclerViewProduct.adapter = ProductAdapter(binding.root.context, productList)
                    }
                }
            }
            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString() )
            }
        } )
    }

    private fun searchProducts(query: String) {
        dummyService.searchProducts(query).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful()) {
                    response.body()?.let {
                        productList = it.products as MutableList<Product>
                        binding.recyclerViewProduct.adapter = ProductAdapter(binding.root.context, productList)
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString() )
            }
        })
    }


}
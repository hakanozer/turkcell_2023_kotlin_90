package com.works.odev_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.works.odev_8.adapter.CustomAdapter
import com.works.odev_8.databinding.ActivityProductsListBinding
import com.works.odev_8.models.Product
import com.works.odev_8.models.Products
import com.works.odev_8.network.ApiClient
import com.works.odev_8.network.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.io.Serializable

class ProductsListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductsListBinding
    private lateinit var dummyService: DummyService
    private lateinit var urunler10: List<Product>
    private lateinit var adapter: CustomAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        recyclerView = binding.rvProductlist
        searchView = binding.svProductsearch

        dummyService.tenProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        urunler10 = ArrayList(it.products)
                        adapter = CustomAdapter(urunler10, onClick = {DetaySayfasinaGit(it)})
                        recyclerView.adapter = adapter
                    }

                    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            return false
                        }

                        override fun onQueryTextChange(newText: String): Boolean {
                            searchProduct(newText)
                            return true
                        }
                    })

                }else{
                    Toast.makeText(applicationContext,"Lütfen internet bağlantınızı kontrol ediniz.",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    private fun DetaySayfasinaGit(product: Product){
        val intent = Intent(applicationContext, ProductsDetail::class.java)
        val gson = Gson()
        val productString = gson.toJson(product)
        intent.putExtra("product", productString)
        startActivity(intent)
    }


    private fun searchProduct(key:String){
        dummyService.productSearch(key).enqueue(object: Callback<Products>{
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if(response.isSuccessful){
                    val productList = response.body()?.products
                    productList.let {
                        adapter.filterProducts(it!!)
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {}

        })
    }


}
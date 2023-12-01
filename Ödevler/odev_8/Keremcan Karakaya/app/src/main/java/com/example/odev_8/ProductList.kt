package com.example.odev_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.odev_8.adapters.ProductAdapter
import com.example.odev_8.configs.ApiClient
import com.example.odev_8.models.Product
import com.example.odev_8.models.Products
import com.example.odev_8.services.DummyService
import com.example.odev_8.utils.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductList : AppCompatActivity() {

    lateinit var dummyService: DummyService
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var searchView: SearchView
    private lateinit var unfilteredProducts: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        searchView = findViewById(R.id.searchView)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        productAdapter = ProductAdapter()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = productAdapter
        val user = Util().getUser(this)
        user?.let {
            Log.d("token", it.token)
        }
        dummyService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.d("products", it.products.toString())
                        unfilteredProducts = it.products
                        productAdapter.updateData(it.products)
                    }
                }
            }
            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString())
            }
        })
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            private val handler = Handler()
            private var currentQuery: String? = null

            private val filterRunnable = object : Runnable {
                override fun run() {
                    if (currentQuery != null && currentQuery!!.isNotEmpty()) {
                        // DummyService'den alınan tüm ürünleri göster
                        dummyService.searchProduct(currentQuery!!).enqueue(object : Callback<Products> {
                            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                                if (response.isSuccessful) {
                                    response.body()?.let {
                                        Log.d("searchedProducts", it.products.toString())
                                        productAdapter.updateData(it.products)
                                    }
                                }
                            }
                            override fun onFailure(call: Call<Products>, t: Throwable) {
                                Log.e("Service Error", t.toString())
                            }
                        })
                    }
                }
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                currentQuery = newText
                handler.removeCallbacks(filterRunnable)

                if (newText.isNullOrEmpty()) {
                    productAdapter.updateData(unfilteredProducts)
                } else {
                    handler.postDelayed(filterRunnable, 300)
                }
                return true
            }
        })
    }
}
package com.example.sefasatilogluvize2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sefasatilogluvize2.adapter.ProductsAdapter
import com.example.sefasatilogluvize2.configs.ApiClient
import com.example.sefasatilogluvize2.databinding.ActivityMainBinding
import com.example.sefasatilogluvize2.models.Product
import com.example.sefasatilogluvize2.models.Products
import com.example.sefasatilogluvize2.services.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var productService: ProductService
    private lateinit var binding: ActivityMainBinding
    private lateinit var productsListesi:ArrayList<Product>
    private lateinit var adapter:ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productService = ApiClient.getClient().create(ProductService::class.java)

        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)

        productService.callProduct().enqueue(object :Callback<Products>{
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                var body = response.body()
                //Log.d("body","$body")

                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.d("products",it.products.toString())
                        productsListesi = ArrayList(it.products)
                        adapter = ProductsAdapter(productService,this@MainActivity,productsListesi)
                        binding.rv.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }

                }else {
                    Log.e("ProductList", "Failed to retrieve products. Response code: ${response.code()}"
                    )
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error",t.toString() )
            }
        })




    }
}
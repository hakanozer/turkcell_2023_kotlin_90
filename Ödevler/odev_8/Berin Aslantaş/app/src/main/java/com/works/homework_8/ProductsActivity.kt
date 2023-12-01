package com.works.homework_8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.works.homework_8.adapter.ProductAdapter
import com.works.homework_8.configs.ApiClient
import com.works.homework_8.databinding.ActivityProductsBinding
import com.works.homework_8.model.Products
import com.works.homework_8.services.DummyJsonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    private lateinit var adapter: ProductAdapter
    private val dummyService: DummyJsonService = ApiClient.getClient().create(DummyJsonService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        dummyService.getProducts(10).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    adapter.setData(response.body()!!)
                } else {
                    Log.v("data", "gelmedi")
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.v("data", "fail")
            }
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    searchProducts(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rv.layoutManager = LinearLayoutManager(this)
        adapter = ProductAdapter(Products(emptyList())) { position ->
            navigateToDetail(position)
        }
        binding.rv.adapter = adapter
    }

    private fun searchProducts(query: String) {
        dummyService.searchProducts(query = query).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    adapter.setData(response.body()!!)
                } else {
                    Log.v("data", "gelmedi")
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.v("data", "fail")
            }
        })
    }

    private fun navigateToDetail(position: Int) {
        val intent = Intent(this@ProductsActivity, DetailActivity::class.java)
        val product = adapter.getItemAtPosition(position)
        intent.putExtra("title", product.title)
        intent.putExtra("price", product.price)
        intent.putExtra("image", product.image)
        startActivity(intent)
    }
}


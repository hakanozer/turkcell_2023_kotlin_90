package com.davutkarakus.turkcellgelecegiyazanlarvize2.view

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davutkarakus.turkcellgelecegiyazanlarvize2.R
import com.davutkarakus.turkcellgelecegiyazanlarvize2.adapter.ProductAdapter
import com.davutkarakus.turkcellgelecegiyazanlarvize2.configs.ApiClient
import com.davutkarakus.turkcellgelecegiyazanlarvize2.model.Product
import com.davutkarakus.turkcellgelecegiyazanlarvize2.model.Products
import com.davutkarakus.turkcellgelecegiyazanlarvize2.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriteActivity : AppCompatActivity() {

    private lateinit var recyclerList : RecyclerView
    private lateinit var dummyService: DummyService
    private lateinit var adapter: ProductAdapter
    private lateinit var productList:ArrayList<Product>
    private lateinit var idList : List<Long>
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Favorites"
        recyclerList = findViewById(R.id.favoritesRecyclerList)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        recyclerList.layoutManager = GridLayoutManager(this,2)

    }

    override fun onResume() {
        super.onResume()
        fetchDataFromRetrofit()
    }

    private fun fetchDataFromRetrofit() {
        idList = listOf()
        productList = arrayListOf()
        val favorites = sharedPreferences.getString("favorites", "") ?: ""
        idList = favorites.split(",").filter { it.isNotEmpty() }.map { it.toLong() }
        for (i in idList) {
            dummyService.getProduct(i).enqueue(object : Callback<Product> {
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            productList.add(it)
                            productList.sortBy { product ->
                                product.id
                            }
                            adapter.notifyDataSetChanged()
                        }
                    }
                }
                override fun onFailure(call: Call<Product>, t: Throwable) {
                    Log.e("Service Error", t.toString())
                }
            })
        }
        adapter = ProductAdapter(productList)
        recyclerList.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
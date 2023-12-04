package com.davutkarakus.turkcellgelecegiyazanlarvize2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
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

class MainActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var recyclerList : RecyclerView
    private lateinit var dummyService: DummyService
    private lateinit var adapter: ProductAdapter
    private lateinit var productList:List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchView)
        recyclerList = findViewById(R.id.recyclerList)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        supportActionBar?.title = "Product List"
        recyclerList.layoutManager = GridLayoutManager(this,2)

        fetchDataFromRetrofit()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    searchProduct(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    searchProduct(newText)
                }
                return true
            }
        })

    }

    private fun fetchDataFromRetrofit(){
        dummyService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {

                if(response.isSuccessful){
                    response.body()?.let {
                        productList = it.products
                        adapter = ProductAdapter(productList)
                        recyclerList.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString())
            }
        })
    }

    fun searchProduct(query:String) {
        dummyService.searchProduct(query).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {

                if(response.isSuccessful){
                    response.body()?.let {
                        productList = it.products
                        println(productList)
                        adapter = ProductAdapter(productList)
                        recyclerList.adapter = adapter
                    }
                }
            }
            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString())
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_favorites -> {
                val intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
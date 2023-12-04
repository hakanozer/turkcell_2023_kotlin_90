package com.example.vize_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vize_2.adapters.ProductAdapter
import com.example.vize_2.models.Product
import com.example.vize_2.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.vize_2.configs.ApiClient

class ProductFavori : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var dummyService: DummyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_favori)

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        productAdapter = ProductAdapter()

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = productAdapter

        val homeButton: ImageButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, ProductList::class.java)
            startActivity(intent)
        }
        val updatedFavorites = intent.getSerializableExtra("updatedFavorites") as? ArrayList<Long>
        if (updatedFavorites != null) {
            fetchProductsDetails(updatedFavorites)
        } else {
            val favoriteIds = getFavoritesFromSharedPreferences()
            fetchProductsDetails(favoriteIds)
        }
    }
    private fun fetchProductsDetails(favoriteIds: List<Long>) {
        val productDetails = mutableListOf<Product>()
        for (productId in favoriteIds) {
            dummyService.getProduct(productId).enqueue(object : Callback<Product?> {
                override fun onResponse(call: Call<Product?>, response: Response<Product?>) {
                    if (response.isSuccessful) {
                        val product = response.body()
                        if (product != null) {
                            productDetails.add(product)
                            productAdapter.submitList(productDetails)
                        }
                    } else {
                        Log.e("Service Error", response.errorBody()?.string() ?: "Unknown error")
                    }
                }
                override fun onFailure(call: Call<Product?>, t: Throwable) {
                    Log.e("Service Error", t.toString())
                }
            })
        }
    }
    private fun getFavoritesFromSharedPreferences(): List<Long> {
        val sharedPreferences = getSharedPreferences("Favorites", Context.MODE_PRIVATE)
        val favoritesSet = sharedPreferences.getStringSet("favorites", HashSet()) ?: HashSet()
        return favoritesSet.map { it.toLong() }
    }
}

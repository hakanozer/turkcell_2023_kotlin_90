package com.davutkarakus.turkcellgelecegiyazanlarvize2.view

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.davutkarakus.turkcellgelecegiyazanlarvize2.R
import com.davutkarakus.turkcellgelecegiyazanlarvize2.configs.ApiClient
import com.davutkarakus.turkcellgelecegiyazanlarvize2.model.Product
import com.davutkarakus.turkcellgelecegiyazanlarvize2.service.DummyService
import com.davutkarakus.turkcellgelecegiyazanlarvize2.util.downloadFromUrl
import com.davutkarakus.turkcellgelecegiyazanlarvize2.util.placeholderProgressBar
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var dummyService: DummyService
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView:TextView
    private lateinit var detailImage: ImageView
    private lateinit var priceTextView:TextView
    private lateinit var stockTextView:TextView
    private lateinit var ratingTextView: TextView
    private lateinit var brandTextView: TextView
    private lateinit var categoryTextView: TextView
    private lateinit var favoriteImageView: ImageView
    private lateinit var favoriteUnfilledImageView: ImageView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initializeComponents()

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val productId = intent.extras?.getLong("product_id")
        val productName = intent.extras?.getString("product_name")
        supportActionBar?.title = productName ?: "Product Detail"
        if (productId != null) {
            val isFavorite = isProductInFavorites(productId)
            updateFavoriteButtons(isFavorite)
            fetchDataFromRetrofit(productId)
        } else {
            Log.d("Product id","Null")
        }

        favoriteUnfilledImageView.setOnClickListener {
            if (productId != null) {
                addProductToFavorites(productId)
            }
        }

        favoriteImageView.setOnClickListener {
            if (productId != null) {
                addProductToFavorites(productId)
            }
        }

    }

    private fun fetchDataFromRetrofit(productId: Long){
        dummyService.getProduct(productId).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    val product = response.body()
                    if (product != null) {
                        titleTextView.text = product.title
                        descriptionTextView.text = product.description
                        priceTextView.text = "${product.price} $"
                        stockTextView.text = product.stock.toString()
                        ratingTextView.text = product.rating.toString()
                        brandTextView.text = product.brand
                        categoryTextView.text = product.category
                        detailImage.downloadFromUrl(product.thumbnail,
                            placeholderProgressBar(this@DetailActivity)
                        )
                    }
                }else {
                    Log.e("Response","Fail")
                }
            }
            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.e("Retrofit fail",t.toString())
            }
        })
    }

    fun addProductToFavorites(productId: Long) {
        val favorites = sharedPreferences.getString("favorites", "") ?: ""
        val favoritesList = favorites.split(",").filter { it.isNotEmpty() }.toMutableList()

        if (!favoritesList.contains(productId.toString())) {
            favoritesList.add(productId.toString())
            sharedPreferences.edit().putString("favorites", favoritesList.joinToString(",")).apply()
            Snackbar.make(favoriteImageView, "Added to Favorites", Snackbar.LENGTH_SHORT).show()
            updateFavoriteButtons(true)
        } else {
            removeProductFromFavorites(productId)
            updateFavoriteButtons(false)
        }
    }

    fun updateFavoriteButtons(isFavorite: Boolean) {
        if (isFavorite) {
            favoriteImageView.visibility = View.VISIBLE
            favoriteUnfilledImageView.visibility = View.GONE
        } else {
            favoriteImageView.visibility = View.GONE
            favoriteUnfilledImageView.visibility = View.VISIBLE
        }
    }

    fun initializeComponents() {
        titleTextView = findViewById(R.id.detailTitleTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        detailImage = findViewById(R.id.imageViewDetail)
        priceTextView = findViewById(R.id.detailPriceTextView)
        stockTextView = findViewById(R.id.stockTextView)
        ratingTextView = findViewById(R.id.ratingTextView)
        brandTextView = findViewById(R.id.brandTextView)
        categoryTextView = findViewById(R.id.categoryTextView)
        favoriteImageView = findViewById(R.id.favoriteImageView)
        favoriteUnfilledImageView = findViewById(R.id.favoriteUnfilledImageView)
    }

    fun isProductInFavorites(productId: Long): Boolean {
        val favorites = sharedPreferences.getString("favorites", "") ?: ""
        val favoritesList = favorites.split(",").filter { it.isNotEmpty() }.map { it.toLong() }
        return favoritesList.contains(productId)
    }

    fun removeProductFromFavorites(productId: Long) {
        val favorites = sharedPreferences.getString("favorites", "") ?: ""
        val favoritesList = favorites.split(",").filter { it.isNotEmpty() }.toMutableList()

        if (favoritesList.contains(productId.toString())) {
            favoritesList.remove(productId.toString())
            sharedPreferences.edit().putString("favorites", favoritesList.joinToString(",")).apply()
            Snackbar.make(favoriteImageView, "Removed from Favorites", Snackbar.LENGTH_SHORT).show()
        }
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
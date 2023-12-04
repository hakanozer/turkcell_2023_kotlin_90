package com.example.vize_2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.vize_2.configs.ApiClient
import com.example.vize_2.models.Product
import com.example.vize_2.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetail : AppCompatActivity() {

    lateinit var likeBtn: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productId = intent.getLongExtra("productId", 0L)

        val dummyService = ApiClient.getClient().create(DummyService::class.java)
        likeBtn = findViewById(R.id.likeBtn)
        likeBtn.setOnClickListener {
            addOrRemoveFromFavorites(productId)
        }

        val homeButton: ImageButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, ProductList::class.java)
            startActivity(intent)
        }

        dummyService.getProduct(productId).enqueue(object : Callback<Product?> {
            override fun onResponse(call: Call<Product?>, response: Response<Product?>) {
                if (response.isSuccessful) {
                    val product = response.body()

                    val productName = findViewById<TextView>(R.id.detailProductName)
                    val productDescription = findViewById<TextView>(R.id.productDescription)
                    val productRating = findViewById<TextView>(R.id.productRating)
                    val productStock = findViewById<TextView>(R.id.productStock)
                    val productCategory = findViewById<TextView>(R.id.productCategory)
                    val productBrand = findViewById<TextView>(R.id.productBrand)
                    val productDetailPrice = findViewById<TextView>(R.id.productDetailPrice)
                    val productDetailImage = findViewById<ImageView>(R.id.productDetailImage)

                    productName.text = product?.title
                    productDescription.text = product?.description
                    productRating.text = "Rating: ${product?.rating}"
                    productStock.text = "Stok: ${product?.stock}"
                    productCategory.text = "Kategori: ${product?.category}"
                    productBrand.text = "Marka: ${product?.brand}"
                    productDetailPrice.text = "Fiyat: ${product?.price} TL"

                    if (product?.images?.isNotEmpty() == true) {
                        val imageUrl = product.images[0]
                        Glide.with(productDetailImage.context)
                            .load(imageUrl)
                            .into(productDetailImage)
                    }
                } else {

                }
            }
            override fun onFailure(call: Call<Product?>, t: Throwable) {
                Log.e("ProductDetail", t.toString())
            }
        })
    }
    private fun addOrRemoveFromFavorites(productId: Long) {
        val favorites = getFavoritesFromSharedPreferences()
        if (!favorites.contains(productId)) {
            favorites.add(productId)
            saveFavoritesToSharedPreferences(favorites)
            Toast.makeText(this, "Ürün favorilere eklendi", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Ürün zaten favorilerde", Toast.LENGTH_SHORT).show()
        }
    }
    private fun getFavoritesFromSharedPreferences(): MutableList<Long> {
        val sharedPreferences = getSharedPreferences("Favorites", Context.MODE_PRIVATE)
        val favoritesSet = sharedPreferences.getStringSet("favorites", HashSet()) ?: HashSet()
        return favoritesSet.map { it.toLong() }.toMutableList()
    }
    private fun saveFavoritesToSharedPreferences(favorites: List<Long>) {
        val sharedPreferences = getSharedPreferences("Favorites", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val favoritesSet = HashSet<String>(favorites.map { it.toString() })
        editor.putStringSet("favorites", favoritesSet)
        editor.apply()
    }
}

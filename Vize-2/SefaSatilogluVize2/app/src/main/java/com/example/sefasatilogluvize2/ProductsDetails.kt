package com.example.sefasatilogluvize2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sefasatilogluvize2.configs.ApiClient
import com.example.sefasatilogluvize2.databinding.ActivityProductsDetailsBinding
import com.example.sefasatilogluvize2.models.Product
import com.example.sefasatilogluvize2.services.ProductService
import com.squareup.picasso.Picasso
import retrofit2.create

class ProductsDetails : AppCompatActivity() {
    private lateinit var productService: ProductService
    private lateinit var binding: ActivityProductsDetailsBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productService = ApiClient.getClient().create(ProductService::class.java)
        sharedPreferences = getSharedPreferences("favorites", Context.MODE_PRIVATE)

        binding.btnGoster.setOnClickListener {

            startActivity(Intent(applicationContext,FavoriProducts::class.java))
        }

        val product:Product? = intent.getSerializableExtra("product")as? Product

        if (product != null) {
            productDetails(product)
        }
    }

    fun productDetails(product:Product) {

        binding.txtDetailsTitle.text = product.title
        binding.txtDescription.text = product.description
        binding.txtBrand.text = "Brand: ${product.brand}"
        binding.txtCategory.text = "Category: ${product.category}"
        binding.txtStock.text = "Stock: ${product.stock}"
        binding.txtDetailsPrice.text = "Price: ${product.price}$"
        binding.imgFavoriButton.setOnClickListener {
            toggleFavori(product.id)
        }

        Picasso.get()
            .load(product.images.firstOrNull())
            .into(binding.imgDetails)


    }

    private fun setFavoriteButtonState(productId: Long) {
        // Favori durumu kontrol edilir, eğer favorideyse butonun görünümü güncellenir.
        if (isProductInFavorites(productId)) {
            binding.imgFavoriButton.setImageResource(R.drawable.love)
        } else {
            binding.imgFavoriButton.setImageResource(R.drawable.love)
        }
    }

    private fun toggleFavori(productId: Long) {
        val favorites = getFavorites()

        if (!favorites.contains(productId.toString())) {
            favorites.add(productId.toString())
            saveFavorites(favorites)
            Toast.makeText(this, "Product Eklendi", Toast.LENGTH_SHORT).show()
        } else {
            favorites.remove(productId.toString())
            saveFavorites(favorites)
            Toast.makeText(this, "Product Çıkarildi", Toast.LENGTH_SHORT).show()
        }

        // Favori butonunun görünümünü güncelle
        setFavoriteButtonState(productId)
    }

    private fun getFavorites(): MutableSet<String> {
        return sharedPreferences.getStringSet("favorites", mutableSetOf()) ?: mutableSetOf()
    }

    private fun saveFavorites(favorites: MutableSet<String>) {
        sharedPreferences.edit().putStringSet("favorites", favorites).apply()
    }

    private fun isProductInFavorites(productId: Long): Boolean {
        val favorites = getFavorites()
        return favorites.contains(productId.toString())
    }
}
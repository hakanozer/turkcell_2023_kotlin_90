package com.works.snav

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.works.snav.Product
import com.works.snav.RetrofitClient
import android.content.SharedPreferences
import android.content.Context
import android.view.View


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.works.snav.ProductAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import android.widget.TextView
import android.widget.Toast


class ProductDetailActivity : AppCompatActivity() {
    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)


        val product = intent.getSerializableExtra("product") as Product


        findViewById<TextView>(R.id.productTitle).text = product.title
        findViewById<TextView>(R.id.productDescription).text = product.description
        findViewById<TextView>(R.id.productPrice).text = getString(R.string.product_price, product.price)
        findViewById<TextView>(R.id.productRating).text = getString(R.string.product_rating, product.rating)


        val imageView = findViewById<ImageView>(R.id.productImage)
        Glide.with(this)
            .load(product.imageUrl)
            .into(imageView)

        fun onLikeButtonClick(view: View) {
            val productId = intent.getIntExtra("productId", -1)
            if (productId != -1) {

                val prefs = getProductPreferences()
                prefs.putProduct(productId, true)

                Toast.makeText(this, "Ürünü Beğendiniz!", Toast.LENGTH_SHORT).show()
            }
        }




    }
}
fun SharedPreferences.putProduct(productId: Int, isFavorite: Boolean) {
    edit().apply {
        if (isFavorite) {
            putInt("FAVORITE_PRODUCT_$productId", productId)
        } else {
            remove("FAVORITE_PRODUCT_$productId")
        }
        apply()
    }
}




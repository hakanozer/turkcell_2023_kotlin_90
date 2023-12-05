package com.works.vize_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // Intent'ten tıklanan ürünü al
        val clickedProduct = intent.getSerializableExtra("product") as Product

        // Burada tıklanan ürünün detaylarını görüntüle
        val productNameTextView: TextView = findViewById(R.id.productDetailTitleTextView)
        val productPriceTextView: TextView = findViewById(R.id.productDetailPriceTextView)
        val productImageView: ImageView = findViewById(R.id.productDetailImageView)
        val productDiscountTextView: TextView = findViewById(R.id.productDetailDiscountTextView)
        val productRatingTextView: TextView = findViewById(R.id.productDetailRatingTextView)
        val productStockTextView: TextView = findViewById(R.id.productDetailStockTextView)

        productNameTextView.text = clickedProduct.title
        productPriceTextView.text = "Price: ${clickedProduct.price} TL"
        productDiscountTextView.text = "Discount: ${clickedProduct.discountPercentage}%"
        productRatingTextView.text = "Rating: ${clickedProduct.rating}"
        productStockTextView.text = "Stock: ${clickedProduct.stock}"

        Glide.with(this)
            .load(clickedProduct.images.firstOrNull())
            .into(productImageView)
    }
}

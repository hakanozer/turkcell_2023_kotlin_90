package com.works.odev_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.works.odev_8.databinding.ActivityProductsDetailBinding
import com.works.odev_8.databinding.ActivityProductsListBinding
import com.works.odev_8.models.Product

class ProductsDetail : AppCompatActivity() {

    private lateinit var binding: ActivityProductsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val brand = binding.txtBrandDetail
        val price = binding.txtPriceDetail
        val title = binding.txtTitleDetail
        val description = binding.txtDescriptionDetail
        val image = binding.imgPdetail
        val rating = binding.txtRatingDetail

        val product = fromJsonAsProduct()

        if (product != null) {
            Picasso.get()
                .load(product.images.firstOrNull())
                .into(image)
            brand.text = product.brand
            price.text = "${product.price}$"
            title.text = product.title
            description.text = product.description
            rating.text = "${product.rating.toString()} out of 5"

        }
    }

    private fun fromJsonAsProduct() : Product? {
        val gson = Gson()
        val productString = intent.getStringExtra("product")
        productString.let {
            return gson.fromJson(productString, Product::class.java)
        }
        return null
    }
}
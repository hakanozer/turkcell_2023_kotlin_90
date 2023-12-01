package com.example.odev_8

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.odev_8.configs.ApiClient
import com.example.odev_8.configs.ApiClient.getClient
import com.example.odev_8.models.Product
import com.example.odev_8.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productId = intent.getLongExtra("productId", 0L)

        val dummyService = ApiClient.getClient().create(DummyService::class.java)
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
                    Toast.makeText(this@ProductDetail, "Ürün bulunamadı", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Product?>, t: Throwable) {
                Log.e("ProductDetail", t.toString())
            }
        })
    }
}
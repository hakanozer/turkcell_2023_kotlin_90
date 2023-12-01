package com.works.odev_8

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.works.odev_8.configs.Client
import com.works.odev_8.model.Product
import com.works.odev_8.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val productId = intent.getLongExtra("productId", 0L)

        val dummyService = Client.getClient().create(DummyService::class.java)
        dummyService.getProducts(productId).enqueue(object : Callback<Product?> {
            override fun onResponse(call: Call<Product?>, response: Response<Product?>) {
                if (response.isSuccessful) {
                    val product = response.body()

                    val productName = findViewById<TextView>(R.id.detail_ProductName)
                    val productDescription = findViewById<TextView>(R.id.productDescription)
                    val productRating = findViewById<TextView>(R.id.productRating)
                    val productStock = findViewById<TextView>(R.id.productStock)
                    val productCategory = findViewById<TextView>(R.id.productCategory)
                    val productDetailPrice = findViewById<TextView>(R.id.product_DetailPrice)

                    productName.text = product?.title
                    productDescription.text = product?.description
                    productRating.text = "Rating: ${product?.rating}"
                    productStock.text = "Stok: ${product?.id}"
                    productCategory.text = "Kategori: ${product?.discountPercentage}"
                    productDetailPrice.text = "Fiyat: ${product?.price} TL"

                } else {
                    Toast.makeText(this@ProductDetail, "İstenilen ürün yoktur.", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Product?>, t: Throwable) {
                Log.e("ProductDetail", t.toString())
            }
        })
    }
}
package com.davutkarakus.turkcellgelecegiyazanlarodev8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.davutkarakus.turkcellgelecegiyazanlarodev8.R
import com.davutkarakus.turkcellgelecegiyazanlarodev8.Service.DummyService
import com.davutkarakus.turkcellgelecegiyazanlarodev8.Util.downloadFromUrl
import com.davutkarakus.turkcellgelecegiyazanlarodev8.Util.placeholderProgressBar
import com.davutkarakus.turkcellgelecegiyazanlarodev8.configs.ApiClient
import com.davutkarakus.turkcellgelecegiyazanlarodev8.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var dummyService: DummyService
    private lateinit var titleTextView:TextView
    private lateinit var descriptionTextView:TextView
    private lateinit var detailImage:ImageView
    private lateinit var priceTextView:TextView
    private lateinit var stockTextView:TextView
    private lateinit var ratingTextView: TextView
    private lateinit var brandTextView: TextView
    private lateinit var categoryTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleTextView = findViewById(R.id.detailTitleTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        detailImage = findViewById(R.id.imageViewDetail)
        priceTextView = findViewById(R.id.detailPriceTextView)
        stockTextView = findViewById(R.id.stockTextView)
        ratingTextView = findViewById(R.id.ratingTextView)
        brandTextView = findViewById(R.id.brandTextView)
        categoryTextView = findViewById(R.id.categoryTextView)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        val productId = intent.extras?.getLong("product_id")
        val productName = intent.extras?.getString("product_name")
        supportActionBar?.title = productName ?: "Ürün Detayı"
        if (productId != null) {
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
        } else {
            Log.d("Product id","Null")
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
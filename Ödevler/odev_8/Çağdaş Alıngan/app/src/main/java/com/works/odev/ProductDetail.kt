package com.works.odev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.works.odev.config.ApiClient
import com.works.odev.databinding.ActivityProductDetailBinding
import com.works.odev.model.Product
import com.works.odev.model.Products
import com.works.odev.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetail : AppCompatActivity() {

    private lateinit var dummyService: DummyService
    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var list: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        list = ArrayList()

        dummyService.tenProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let { products ->
                        if (products.products.isNotEmpty()) {
                            val selectedProduct = intent.getSerializableExtra("product") as? Product
                            selectedProduct?.let {
                                binding.apply {
                                    txtTitle.text = it.title
                                    txtPrice.text = "Price: ${it.price}"
                                    txtProductId.text = "İd :${it.id}"
                                    txtDesc.text = "Description :${it.description}"
                                    txtDisc.text = "Discountpercentage :${it.discountPercentage}"
                                    txtRating.text = "Rating :${it.rating}"
                                    txtStock.text = "Stock :${it.stock}"
                                    txtBrand.text = "Brand :${it.brand}"
                                    txtCategory.text = "Category :${it.category}"
                                    txtThumbnail.text = "Thumnail :${it.thumbnail}"
                                }
                            Glide.with(this@ProductDetail)
                                .load(it.thumbnail)
                                .into(binding.imgProduct)
                        }
                        } else {
                            Log.e("Response", "Products list is empty")
                        }
                    }
                } else {
                    Log.e("Response", "Fail")
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Fail", t.toString())
            }
        })
    }
}

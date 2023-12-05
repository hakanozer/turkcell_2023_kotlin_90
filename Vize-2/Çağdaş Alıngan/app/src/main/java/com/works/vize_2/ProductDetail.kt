package com.works.vize_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.works.vize_2.configs.ApiClient
import com.works.vize_2.databinding.ActivityProductDetailBinding
import com.works.vize_2.models.Product
import com.works.vize_2.models.Products
import com.works.vize_2.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetail : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var binding : ActivityProductDetailBinding
    lateinit var list: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        list = ArrayList()

        dummyService.allProducts().enqueue(object : Callback<Products>{
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful){
                    response.body()?.let {products ->
                        if (products.products.isNotEmpty()){
                            val selectedProduct = intent.getSerializableExtra("product") as? Product
                            selectedProduct?.let {
                                binding.apply {
                                    txtTitle.text = it.title
                                    txtDesc.text = it.description
                                    txtPrice.text = "Fiyat : ${it.price}"
                                    txtRating.text = "Puan : ${it.rating}"
                                    Glide.with(this@ProductDetail)
                                        .load(it.thumbnail)
                                        .into(imgProduct)

                                }
                            }
                        }else{
                            Log.e("Response", "Product list empty" )
                        }
                    }
                }else{
                    Log.e("Response", "Fail ", )
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Fail", t.toString())
            }
        })

        binding.btnLike.setOnClickListener {
            val selectedProduct = intent.getSerializableExtra("product") as? Product
            selectedProduct?.let {

            }
        }
    }
}
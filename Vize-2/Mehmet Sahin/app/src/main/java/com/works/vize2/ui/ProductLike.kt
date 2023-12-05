package com.works.vize2.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.works.vize2.configs.ApiClient
import com.works.vize2.databinding.ActivityProductLikeBinding
import com.works.vize2.models.Product
import com.works.vize2.models.Products
import com.works.vize2.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class ProductLike : AppCompatActivity() {
    private lateinit var dummyService: DummyService
    private lateinit var binding: ActivityProductLikeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductLikeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initServices()
        fetchProductsAndUpdateLike()

    }


    private fun initServices() {
        dummyService = ApiClient.getClient().create(DummyService::class.java)
    }
    //dummy kullanarak API çağrısı yapma
    private fun fetchProductsAndUpdateLike() {
        val likeList = convertLikesToStrList().map { str->
            str.toLong() }

        dummyService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                val status = response.code()
                if(status == 200) {
                    val allProduct = response.body()!!.products
                    val likedProducts = allProduct.filter { product ->
                        likeList.contains(product.id)
                    }
                    updateLikedProducts(likedProducts)
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Error", t.toString())
            }

        })


    }

    //beğenilen ürünleri filtreleme ve geri döndürme
    private fun filterLikedProducts(products: List<Product>, likeList: List<String> ) : List<Product> {
        val likedIds = likeList.mapNotNull { it.toLongOrNull() }
        return products.filter {product->
            likedIds.contains(product.id) }
    }
   //beğenilen ürünleri güncelleme
    private fun updateLikedProducts(likedProducts: List<Product>) {
        if(!likedProducts.isEmpty()) {
            val builder = StringBuilder()
            likedProducts.forEach { product->
                builder.append(product.title).append("\n")
            }
            binding.txtTitle.text = builder.toString()
        }

    }

    //ShrPref'ten beğenileri alıp list döndürme
    private fun convertLikesToStrList() : List<String> {
        val sharedPreferences = this.getSharedPreferences("like", Context.MODE_PRIVATE)
        return sharedPreferences.getStringSet("like", setOf())?.toList().orEmpty()
    }
}
package com.example.sefasatilogluvize2.services




import com.example.sefasatilogluvize2.models.Product
import com.example.sefasatilogluvize2.models.Products

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ProductService {

    @GET("products")
    fun callProduct():Call<Products>

    @GET("products/{id}")
    fun callDetailsProduct(@Path("id")productsId:Int):Call<Product>

    @GET("products")
    fun getProducts(@Query("productIds") productIds: List<Long>): Call<Products>


}
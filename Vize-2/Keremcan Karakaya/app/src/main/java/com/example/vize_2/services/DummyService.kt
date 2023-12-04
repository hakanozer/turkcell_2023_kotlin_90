package com.example.vize_2.services

import com.example.vize_2.models.Product
import com.example.vize_2.models.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {
    @GET("products")
    fun allProducts(): Call<Products>

    @GET("products/{id}")
    fun getProduct(@Path("id") id:Long) : Call<Product>

    @GET("products")
    fun getProducts(@Query("productIds") productIds: List<Long>): Call<Products>

}
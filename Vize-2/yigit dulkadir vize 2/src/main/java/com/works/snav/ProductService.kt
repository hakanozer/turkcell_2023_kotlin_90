package com.works.snav

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("products")
    fun listProducts(): Call<List<Product>>

    @GET("products/{id}")
    fun getProductDetails(@Path("id") id: Int): Call<Product>
}

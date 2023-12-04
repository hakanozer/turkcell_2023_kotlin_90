package com.example.kotlinvize2.Network.service

import com.example.kotlinvize2.model.Product
import com.example.kotlinvize2.model.Products
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {
    @GET("products")
    suspend fun getProducts() : Products

    @GET("products/search?")
    suspend fun searchProduct(@Query("q") query :String) : Products

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") productId :String) : Product
}
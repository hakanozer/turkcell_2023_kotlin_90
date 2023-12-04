package com.example.vize_2.service


import com.example.vize_2.model.ProductList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    //https://dummyjson.com/products
    //https://dummyjson.com/products/1

    @GET("products")
    fun getProduct(): Call<ProductList>

    @GET("products/search")
    fun searchProduct(@Query("q") searchQuery: String): Call<ProductList>

    @GET("products/1")
    fun getLikeProduct(): Call<Favori>
}
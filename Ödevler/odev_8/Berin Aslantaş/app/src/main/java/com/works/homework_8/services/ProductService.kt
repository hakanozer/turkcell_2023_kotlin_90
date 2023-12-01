package com.works.homework_8.services

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {
    @GET("products/10")
    fun getProducts(): Call<JsonObject>
}
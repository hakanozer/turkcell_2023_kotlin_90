package com.ao.nagihanarabaci.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductsService {
    private val BASE_URL = "https://dummyjson.com/"

    val api:ProductsApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsApi::class.java)
    }
}
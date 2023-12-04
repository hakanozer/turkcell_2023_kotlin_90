package com.example.vize_2.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiResponse {

    private const val URL ="https://dummyjson.com/"

    private val retrofitBuilder =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL).build()

    val apiRetrofitService: ApiService by lazy {
        retrofitBuilder.create(ApiService::class.java)
    }
}
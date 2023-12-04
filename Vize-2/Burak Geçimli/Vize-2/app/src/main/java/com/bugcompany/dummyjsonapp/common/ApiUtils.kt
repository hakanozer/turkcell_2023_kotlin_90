package com.bugcompany.dummyjsonapp.common

import com.bugcompany.dummyjsonapp.common.Constans.BASE_URL
import com.bugcompany.dummyjsonapp.data.source.remote.ProductApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiUtils {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val productApiService: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }
}

package com.nazlican.turkcellgelecegiyazanlarhomework8.common

import com.nazlican.turkcellgelecegiyazanlarhomework8.data.source.remote.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val service: ProductService? by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductService::class.java)
    }
}
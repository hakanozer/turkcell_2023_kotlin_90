package com.nazlican.turkcellgelecegiyazanlarmidtermproject.common

import com.nazlican.turkcellgelecegiyazanlarmidtermproject.data.source.ProductService
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
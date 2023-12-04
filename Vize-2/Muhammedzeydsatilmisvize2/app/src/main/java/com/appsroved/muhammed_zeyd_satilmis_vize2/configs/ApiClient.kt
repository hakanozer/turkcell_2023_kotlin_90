package com.appsroved.muhammed_zeyd_satilmis_vize2.configs

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val Base_URL = "https://dummyjson.com/"
    private var retrofit: Retrofit? = null

    private val client = OkHttpClient
        .Builder()
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit =
                Retrofit.Builder().baseUrl(Base_URL)
                    .addConverterFactory(
                        GsonConverterFactory
                            .create()
                    ).client(client).build()
        }
        return retrofit!!
    }
}

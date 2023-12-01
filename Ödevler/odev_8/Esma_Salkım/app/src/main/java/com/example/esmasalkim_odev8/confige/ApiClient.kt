package com.example.esmasalkim_odev8.confige

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {


    // retrofit tanımlaması

    // burdaki kodlar sabittir tek değiştirilmesi gereken yer base url dir.

    private val Base_URL = "https://dummyjson.com/"  // buna dikkat et yoksa 200 göremeyiz
    private var retrofit: Retrofit? = null

    private val client = OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    fun getClient():Retrofit{
        if ( retrofit == null ){
            retrofit = Retrofit
                .Builder()
                .baseUrl(Base_URL)  // not found gibi bir hata gelirse base url e ulaşamıyor demektir.
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        // kesinlikle Retrofit cinsinden geri dönecek as ile.
        return retrofit as Retrofit
    }

}
package com.works.vize_2.network

import com.works.vize_2.Products
import retrofit2.Call
import retrofit2.http.GET

interface DummySerrvice {

    @GET("products")
    fun allProducts() : Call<Products>

}
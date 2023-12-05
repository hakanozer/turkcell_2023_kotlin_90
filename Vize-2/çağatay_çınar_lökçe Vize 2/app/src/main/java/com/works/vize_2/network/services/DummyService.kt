package com.works.vize_2.network.services

import com.works.vize_2.models.Products
import retrofit2.Call
import retrofit2.http.GET


interface DummyService {

    @GET("products?limit=10")
    fun products(): Call<Products>

}
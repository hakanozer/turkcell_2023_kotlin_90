package com.works.vize_2.services

import com.works.vize_2.models.Products
import retrofit2.http.GET
import retrofit2.Call

interface DummySService {

    @GET("products")
    fun getProducts() : Call<Products>


}
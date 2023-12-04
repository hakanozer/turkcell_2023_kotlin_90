package com.ao.nagihanarabaci.data

import com.ao.nagihanarabaci.models.Products
import retrofit2.Call
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    fun getProducts(): Call<Products>

}
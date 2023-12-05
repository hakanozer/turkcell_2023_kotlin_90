package com.works.vize2.services

import com.works.vize2.models.Product
import com.works.vize2.models.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {
    @GET("products")
    fun allProducts(): Call<Products>

    @GET("products")
    fun products(@Query("productId") productId : List<Long>): Call<Products>

    @GET("products/{id}")
    fun product(@Path("id") id:Long) : Call<Product>
}
package com.works.homework_8.services

import com.works.homework_8.model.User
import com.works.homework_8.model.Products
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyJsonService {

    @POST("/auth/login")
    fun login(
        @Body User: User
    ): Call<User>

    @GET("/products")
    fun getProducts(
        @Query("limit") limit: Int,
    ): Call<Products>

    @GET("products/search")
    fun searchProducts(@Query("q") query: String): Call<Products>
}
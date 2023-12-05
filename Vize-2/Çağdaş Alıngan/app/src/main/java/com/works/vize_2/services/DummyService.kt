package com.works.vize_2.services

import com.works.vize_2.models.JWTUser
import com.works.vize_2.models.Products
import com.works.vize_2.models.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DummyService {

    @POST("auth/login")
    fun login( @Body userSend: UserSend) : Call<JWTUser>

    @GET("products")
    fun allProducts() : Call<Products>

    @GET("/1")
    fun productDetails() : Call<Products>
}
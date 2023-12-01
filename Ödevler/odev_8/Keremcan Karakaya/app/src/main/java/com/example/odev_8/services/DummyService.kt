package com.example.odev_8.services

import com.example.odev_8.models.JWTUser
import com.example.odev_8.models.Product
import com.example.odev_8.models.Products
import com.example.odev_8.models.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {
    @POST("auth/login")
    fun login(@Body userSend: UserSend) : Call<JWTUser>

    @GET("products?limit=10")
    fun allProducts(): Call<Products>

    @GET("products/search?")
    fun searchProduct(@Query("q") q:String) : Call<Products>

    @GET("products/{id}")
    fun getProduct(@Path("id") id:Long) : Call<Product>

}
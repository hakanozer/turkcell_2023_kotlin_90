package com.example.muhammed_zeyd_satilmis_odev8.services

import com.example.muhammed_zeyd_satilmis_odev8.models.JWTUser
import com.example.muhammed_zeyd_satilmis_odev8.models.Products
import com.example.muhammed_zeyd_satilmis_odev8.models.UserAuth
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IDummyService {

    @POST("auth/login")
    fun login(@Body userAuth: UserAuth): Call<JWTUser>


    @GET("products?limit=10")
    fun getProducts(): Call<Products>

    @GET("products/search?")
    fun searchProducts(@Query("q") query: String): Call<Products>

}

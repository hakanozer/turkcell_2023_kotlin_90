package com.works.odev.services

import com.works.odev.model.JWTUser
import com.works.odev.model.Products
import com.works.odev.model.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyService {
    @POST ("auth/login")
    fun login(@Body userSend: UserSend): Call<JWTUser>

    @GET("products?limit=10")
    fun tenProducts() : Call<Products>

    @GET("products/search?")
    fun filter(@Query("q") q:String) : Call<Products>


}
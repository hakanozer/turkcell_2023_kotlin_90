package com.works.digivista.services

import com.works.digivista.models.JWTUser
import com.works.digivista.models.Products
import com.works.digivista.models.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyService {

    @POST("auth/login")
    fun login( @Body userSend: UserSend) : Call<JWTUser>

    @GET("products?limit=10")
    fun allProducts(): Call<Products>

}
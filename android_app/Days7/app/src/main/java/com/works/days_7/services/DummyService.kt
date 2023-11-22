package com.works.days_7.services

import com.works.days_7.models.JWTUser
import com.works.days_7.models.Products
import com.works.days_7.models.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DummyService {

    @POST("auth/login")
    fun login( @Body userSend: UserSend ) : Call<JWTUser>

    @GET("products")
    fun allProducts () : Call<Products>

}
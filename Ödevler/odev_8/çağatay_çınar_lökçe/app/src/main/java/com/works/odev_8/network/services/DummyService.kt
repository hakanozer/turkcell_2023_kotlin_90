package com.works.odev_8.network.services

import com.works.odev_8.models.JWTUser
import com.works.odev_8.models.Product
import com.works.odev_8.models.Products
import com.works.odev_8.models.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyService {

    @POST("auth/login")
    fun login( @Body userSend: UserSend) : Call<JWTUser>

    @GET("products?limit=10")
    fun tenProducts(): Call<Products>

    @GET("products/search?")
    fun productSearch(@Query("q") query: String): Call<Products>

}
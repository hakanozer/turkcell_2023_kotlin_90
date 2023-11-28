package com.gorkemarslanbogan.ecommer1234.network.services

import com.gorkemarslanbogan.ecommer1234.model.LoginResult
import com.gorkemarslanbogan.ecommer1234.model.Product
import com.gorkemarslanbogan.ecommer1234.model.Products
import com.gorkemarslanbogan.ecommer1234.model.UserLogin
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {

    @POST("auth/login")
    suspend fun login(@Body userLogin: UserLogin) : LoginResult

    @GET("products?=10")
    suspend fun getProducts() : Products

    @GET("products/search?")
    suspend fun searchProduct(@Query("q") query:String) : Products


}
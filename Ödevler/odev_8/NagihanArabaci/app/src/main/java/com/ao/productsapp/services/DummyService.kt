package com.ao.productsapp.services

import com.ao.productsapp.model.JWTUser
import com.ao.productsapp.model.Products
import com.ao.productsapp.model.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyService {
    // login işlemi
    @POST("auth/login")
    fun login( @Body userSend: UserSend) : Call<JWTUser>

    // ilk 10 verinin gösterimi
    @GET("products?limit=10")
    fun allProducts() : Call<Products>

    @GET("products/search")
    fun searchProducts (@Query("q") query:String) : Call<Products>




}
package com.ao.productapp.retrofit

import com.ao.productapp.model.JWTUser
import com.ao.productapp.model.Products
import com.ao.productapp.model.UserSend
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyJsonService {

    // login işlemi
    @POST("auth/login")
    fun login( @Body userSend: UserSend) : retrofit2.Call<JWTUser>

    // ilk 10 verinin gösterimi
    @GET("products?limit=10")
    fun allProducts() : retrofit2.Call<Products>

    @GET("products/search")
    fun searchProducts (@Query("q") query:String) : retrofit2.Call<Products>


}
package com.example.hw8_urun_tantm_uygulamas.service


import com.example.hw8_urun_tantm_uygulamas.model.LoginInformation
import com.example.hw8_urun_tantm_uygulamas.model.ProductInformation
import com.example.hw8_urun_tantm_uygulamas.model.UserInformation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    //https://dummyjson.com/auth/login
    //https://dummyjson.com/products/search
    //https://dummyjson.com/products?limit=10

    @POST("auth/login")
    fun userLogin(@Body loginInformation: LoginInformation): Call<UserInformation>

    @GET("products?limit=10")
    fun getProduct(): Call<ProductInformation>

    @GET("products/search")
    fun searchProduct(@Query("q") searchQuery: String): Call<ProductInformation>
}
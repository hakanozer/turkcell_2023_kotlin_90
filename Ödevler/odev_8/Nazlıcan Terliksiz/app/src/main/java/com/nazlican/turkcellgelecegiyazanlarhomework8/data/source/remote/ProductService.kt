package com.nazlican.turkcellgelecegiyazanlarhomework8.data.source.remote

import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.JwtUser
import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.ProductResponse
import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductService {

    @GET("products?limit=10")
    fun getProducts() : Call<ProductResponse>

    @GET("products/search?")
    fun searchProduct(@Query("query") query:String) : Call<ProductResponse>

    @POST("auth/login")
    fun login(@Body user: User): Call<JwtUser>

}
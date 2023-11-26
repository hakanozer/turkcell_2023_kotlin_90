package com.davutkarakus.turkcellgelecegiyazanlarodev8.Service

import com.davutkarakus.turkcellgelecegiyazanlarodev8.model.JWTUser
import com.davutkarakus.turkcellgelecegiyazanlarodev8.model.Product
import com.davutkarakus.turkcellgelecegiyazanlarodev8.model.Products
import com.davutkarakus.turkcellgelecegiyazanlarodev8.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {

    @POST("auth/login")
    fun login (@Body userSend: User) : Call<JWTUser>

    @GET("products?limit=10")
    fun allProducts() : Call<Products>

    @GET("products/search?")
    fun searchProduct(@Query("q") q:String) : Call<Products>

    @GET("products/{id}")
    fun getProduct(@Path("id") id:Long) : Call<Product>
}
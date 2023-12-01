package com.works.odev_8.service

import retrofit2.Call
import com.works.odev_8.model.JwtUser
import com.works.odev_8.model.Product
import com.works.odev_8.model.Products
import com.works.odev_8.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyService {
    @POST("auth/login")
    fun login(@Body User: User): Call<JwtUser>

    @GET("products")
    fun allProducts(@Query("limit") limit: Int): Call<Products>

    @GET("products/search")
    fun filterProducts(@Query("q") keyword: String): Call<Products>
    fun getProducts(productId: Long): Any
    abstract fun allProducts(): Call<Products>

    companion object {
        fun searchProduct(currentQuery: String): Any {
            TODO("Not yet implemented")
        }
    }
}
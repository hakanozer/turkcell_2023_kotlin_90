package com.works.berinaslantasvize2.services

import com.works.berinaslantasvize2.models.Cart
import com.works.berinaslantasvize2.models.CartPost
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ILikedProductsService {

    @POST("carts/add")
    fun addToCart(@Body cartPost : CartPost) : Call<Cart>

    @GET("carts/{id}")
    fun getCartById(@Path("id") id : Int) : Call<Cart?>
}
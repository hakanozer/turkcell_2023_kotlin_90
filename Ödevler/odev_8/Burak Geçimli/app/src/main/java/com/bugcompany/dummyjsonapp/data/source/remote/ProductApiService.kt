package com.bugcompany.dummyjsonapp.data.source.remote

import com.bugcompany.dummyjsonapp.common.Constans.GET_10_LIMIT_PRODUCT
import com.bugcompany.dummyjsonapp.common.Constans.LOGIN
import com.bugcompany.dummyjsonapp.common.Constans.SEARCH_PRODUCTS
import com.bugcompany.dummyjsonapp.data.model.product.Product
import com.bugcompany.dummyjsonapp.data.model.product.ProductResponse
import com.bugcompany.dummyjsonapp.data.model.user.JwtUser
import com.bugcompany.dummyjsonapp.data.model.user.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ProductApiService {

    @GET(GET_10_LIMIT_PRODUCT)
    fun getAllProduct(): Call<ProductResponse>

    @POST(LOGIN)
    fun login(@Body userSend: UserSend): Call<JwtUser>

    @GET(SEARCH_PRODUCTS)
    fun searchProduct(@Query("q") query: String): Call<ProductResponse>
}
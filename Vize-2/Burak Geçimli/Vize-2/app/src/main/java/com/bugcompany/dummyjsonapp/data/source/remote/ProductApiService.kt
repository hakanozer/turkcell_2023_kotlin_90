package com.bugcompany.dummyjsonapp.data.source.remote

import com.bugcompany.dummyjsonapp.common.Constans.GET_10_LIMIT_PRODUCT
import com.bugcompany.dummyjsonapp.data.model.product.Product
import com.bugcompany.dummyjsonapp.data.model.product.ProductResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ProductApiService {

    @GET(GET_10_LIMIT_PRODUCT)
    fun getAllProduct(@Query("limit") limit: Int=10): Call<ProductResponse>


    @GET("products/{id}")
    fun getProductById(@Path("id") id: Int): Call<Product>

}
package com.works.berinaslantasvize2.services

import com.works.berinaslantasvize2.models.DummyProduct
import com.works.berinaslantasvize2.models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IProductService {

    @GET("products")
    fun products() : Call<DummyProduct?>

    @GET("products/{id}")
    fun getProductById(@Path("id") id : Int) : Call<Product?>


}
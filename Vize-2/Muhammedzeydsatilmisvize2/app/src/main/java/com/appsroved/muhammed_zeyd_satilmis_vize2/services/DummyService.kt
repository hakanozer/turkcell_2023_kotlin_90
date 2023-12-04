package com.appsroved.muhammed_zeyd_satilmis_vize2.services

import com.appsroved.muhammed_zeyd_satilmis_vize2.models.Product
import com.appsroved.muhammed_zeyd_satilmis_vize2.models.ProductsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DummyService {

    @GET("products")
    fun getProducts(): Call<ProductsModel>

    @GET("products/{id}")
    fun getFavorites(@Path("id") id: Long): Call<Product>

}

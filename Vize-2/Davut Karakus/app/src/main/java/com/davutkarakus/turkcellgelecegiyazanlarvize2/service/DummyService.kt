package com.davutkarakus.turkcellgelecegiyazanlarvize2.service

import com.davutkarakus.turkcellgelecegiyazanlarvize2.model.Product
import com.davutkarakus.turkcellgelecegiyazanlarvize2.model.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {

    @GET("products")
    fun allProducts() : Call<Products>

    @GET("products/search?")
    fun searchProduct(@Query("q") q:String) : Call<Products>

    @GET("products/{id}")
    fun getProduct(@Path("id") id:Long) : Call<Product>
}
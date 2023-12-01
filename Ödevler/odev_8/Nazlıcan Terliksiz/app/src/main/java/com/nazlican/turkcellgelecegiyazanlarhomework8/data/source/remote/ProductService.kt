package com.nazlican.turkcellgelecegiyazanlarhomework8.data.source.remote

import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.Product
import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.ProductResponse
import com.nazlican.turkcellgelecegiyazanlarhomework8.util.Constant
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService : List<Product> {

    @GET("products?limit=10")
    fun getProducts() : Call<ProductResponse>

    @GET("products/search?")
    fun searchProduct(@Query("query") query:String) : Call<ProductResponse>

}
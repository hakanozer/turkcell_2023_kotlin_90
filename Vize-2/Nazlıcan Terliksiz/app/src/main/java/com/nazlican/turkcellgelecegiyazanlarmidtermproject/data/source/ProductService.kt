package com.nazlican.turkcellgelecegiyazanlarmidtermproject.data.source

import com.nazlican.turkcellgelecegiyazanlarmidtermproject.data.model.Product
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.data.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    fun  getProducts() : Call<ProductResponse>

    @GET("products/{id}")
    fun getProductDetail(@Path("id") id: Int) : Call<Product>

}
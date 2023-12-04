package com.example.vize_2.repository

import androidx.lifecycle.MutableLiveData
import com.example.vize_2.model.ProductDetailInformation
import com.example.vize_2.model.ProductList
import com.example.vize_2.service.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {

    private val apiResponse = ApiResponse.apiRetrofitService
    val productList = MutableLiveData<List<ProductDetailInformation>?>()

    fun getProduct() {
        apiResponse.getProduct().enqueue(object : Callback<ProductList> {
            override fun onResponse(
                call: Call<ProductList>, response: Response<ProductList>
            ) {
                productList.value = response.body()?.products.takeIf { it!!.isNotEmpty() }
            }

            override fun onFailure(call: Call<ProductList>, t: Throwable) {}
        })
    }

    fun searchProduct(searchQuery: String) {
        apiResponse.searchProduct(searchQuery).enqueue(object : Callback<ProductList> {
            override fun onResponse(
                call: Call<ProductList>, response: Response<ProductList>
            ) {
                if (response.isSuccessful) {
                    productList.value = response.body()?.products.takeIf { it!!.isNotEmpty() }
                }
            }

            override fun onFailure(call: Call<ProductList>, t: Throwable) {}
        })
    }
}
package com.bugcompany.dummyjsonapp.data.source.repository

import androidx.lifecycle.MutableLiveData
import com.bugcompany.dummyjsonapp.common.ApiUtils
import com.bugcompany.dummyjsonapp.data.model.product.Product
import com.bugcompany.dummyjsonapp.data.model.product.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductRepository {
    private val service = ApiUtils.productApiService
    val productDetail = MutableLiveData<Product?>()

    val productList = MutableLiveData<List<Product>?>()


    fun getProducts() {
        service.getAllProduct().enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.products.isNullOrEmpty()) {
                        productList.value = null
                    } else {
                        productList.value = response.body()?.products
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
            }
        })
    }



    fun getProductById(id: Int) {
        service.getProductById(id).enqueue(object : Callback<Product> {
            override fun onResponse(
                call: Call<Product>,
                response: Response<Product>
            ) {
                if (response.isSuccessful) {
                    productDetail.value = response.body()
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
            }
        })
    }


}


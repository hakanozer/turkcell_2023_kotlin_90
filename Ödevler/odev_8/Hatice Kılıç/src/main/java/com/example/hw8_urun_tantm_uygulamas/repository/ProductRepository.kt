package com.example.hw8_urun_tantm_uygulamas.repository

import androidx.lifecycle.MutableLiveData
import com.example.hw8_urun_tantm_uygulamas.model.ProductDetailInformation
import com.example.hw8_urun_tantm_uygulamas.model.ProductInformation
import com.example.hw8_urun_tantm_uygulamas.service.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {
    private val apiResponse = ApiResponse.apiRetrofitService
    val productList = MutableLiveData<List<ProductDetailInformation>?>()

    fun getProduct() {
        apiResponse.getProduct().enqueue(object : Callback<ProductInformation> {
            override fun onResponse(
                call: Call<ProductInformation>, response: Response<ProductInformation>
            ) {
                productList.value = response.body()?.products.takeIf { it!!.isNotEmpty() }
            }

            override fun onFailure(call: Call<ProductInformation>, t: Throwable) {}
        })
    }

    fun searchProduct(searchQuery: String) {
        apiResponse.searchProduct(searchQuery).enqueue(object : Callback<ProductInformation> {
            override fun onResponse(
                call: Call<ProductInformation>, response: Response<ProductInformation>
            ) {
                if (response.isSuccessful) {
                    productList.value = response.body()?.products.takeIf { it!!.isNotEmpty() }
                }
            }

            override fun onFailure(call: Call<ProductInformation>, t: Throwable) {}
        })
    }
}

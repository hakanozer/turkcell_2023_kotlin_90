package com.works.berinaslantasvize2.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.works.berinaslantasvize2.models.DummyProduct
import com.works.berinaslantasvize2.models.Product
import com.works.berinaslantasvize2.services.IProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var productService : IProductService? = null
    var isFailed = MutableLiveData<Boolean>()
    var products = MutableLiveData<List<Product>>()

    fun getProducts(){
        productService?.products()?.enqueue(object : Callback<DummyProduct?>{
            override fun onResponse(call: Call<DummyProduct?>, response: Response<DummyProduct?>) {
                val response = response.body()
                if(response != null){
                    products.value = response.products
                    isFailed.value = false
                }
            }

            override fun onFailure(call: Call<DummyProduct?>, t: Throwable) {
                isFailed.value = true
            }

        })
    }

}
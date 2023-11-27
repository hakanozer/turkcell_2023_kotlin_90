package com.bugcompany.dummyjsonapp.data.source.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.bugcompany.dummyjsonapp.common.ApiUtils
import com.bugcompany.dummyjsonapp.data.model.product.Product
import com.bugcompany.dummyjsonapp.data.model.product.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*Repository classları ile internetten veri çekmek vs. yapılacak işlemler için kullanılan metotları burada çalıştırıp Viewmodel aracılığıyla verileri
View katmanına iletmektir.Bu şekilde bu metotları tek seferde burdan yazıp ihtiyaç duyulan her yerde çağırarak kod tekrarının önüne geçilir.
 */

class ProductRepository {
    private val service = ApiUtils.productApiService

    val productList =
        MutableLiveData<List<Product>?>() // Viewmodelde bu livedata observe edilir.(gözlemlenir.)


    //Tüm ürünleri alır ve alınan ürünleri productList LiveData'sını günceller..
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

    // Kendisine geçilen query ile ürünleri arar ve arama sonuçlarını productList LiveData'sını günceller.
    fun searchProducts(query: String) {
        service.searchProduct(query).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { productResponse ->
                        if (response.body()?.products.isNullOrEmpty()) {
                            productList.value = null
                        } else {
                            productList.value =
                                response.body()?.products //istek başarılı ise gelen cevap ile beraber productList adında ki Livedata'yı güncelle.
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {

            }
        })
    }

}


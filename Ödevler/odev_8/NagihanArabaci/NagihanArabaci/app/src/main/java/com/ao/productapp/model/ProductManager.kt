package com.ao.productapp.model

import android.widget.SearchView
import com.ao.productapp.retrofit.DummyJsonApi
import com.ao.productapp.retrofit.DummyJsonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductManager {

    private val dummyJsonService = DummyJsonApi.getClient().create(DummyJsonService::class.java)
    private var productList = mutableListOf<Product>()

    fun getProducts(onSuccess: (List<Product>) -> Unit, onError: (Throwable) -> Unit) {
        dummyJsonService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        productList = it.products as MutableList<Product>
                        // Başarılı olması durumunda productList'i onSuccess fonksiyonuna gönderiyoruz.
                        onSuccess(productList)
                    }
                } else {
                    onError(RuntimeException("Request failed"))
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                onError(t)
            }
        })
    }

    fun searchProducts(query: String, onSuccess: (List<Product>) -> Unit, onError: (Throwable) -> Unit) {
        dummyJsonService.searchProducts(query).enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        productList = it.products as MutableList<Product>
                        // Arama kelimesini aldıktan sonra başarılı durumunda listemizi onSuccess fonksiyonuna gönderiyoruz.
                        onSuccess(productList)
                    }
                } else {
                    onError(RuntimeException("Request failed"))
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                onError(t)
            }
        })
    }

    fun setSearchViewListener(
        searchView: SearchView,
        onSuccess: (List<Product>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    searchProducts(query, onSuccess, onError)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // burada da arama çubuğu boş ise tüm ürünleri getiriyoruz.
                if (newText.isNullOrEmpty()) {
                    getProducts(onSuccess, onError)
                }
                return true
            }
        })
    }
}
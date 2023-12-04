package com.example.kotlinvize2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinvize2.model.Product
import com.example.kotlinvize2.repository.DummyServiceRepository
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val repository: DummyServiceRepository by lazy { DummyServiceRepository() }
    private val _products = MutableLiveData<List<Product>>()
    var singleProductLiveData = MutableLiveData<Product>()
    val products: LiveData<List<Product>> get() = _products

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch{
            val productList = repository.getProducts()
            productList.let { products ->
                _products.value = products.products
            }
        }
    }


    fun searchProduct(query: String) {
        viewModelScope.launch{
            val productList = repository.searchProduct(query)
            productList.let { products ->
                _products.value = products.products
            }
        }
    }

    fun getProductById(productId: String) {
        viewModelScope.launch{
            val product = repository.getProductById(productId)
            product.let {
                singleProductLiveData.postValue(product)
            }
        }
    }
}
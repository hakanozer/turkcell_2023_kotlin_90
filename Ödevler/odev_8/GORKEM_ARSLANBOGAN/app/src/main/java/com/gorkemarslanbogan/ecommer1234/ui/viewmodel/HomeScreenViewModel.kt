package com.gorkemarslanbogan.ecommer1234.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorkemarslanbogan.ecommer1234.model.Product
import com.gorkemarslanbogan.ecommer1234.repository.DummyServiceRepository
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val repository: DummyServiceRepository by lazy { DummyServiceRepository() }
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

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

}
package com.bugcompany.dummyjsonapp.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bugcompany.dummyjsonapp.data.source.repository.ProductRepository
import com.bugcompany.dummyjsonapp.data.model.product.Product

class ProductLisViewModel : ViewModel() {
    val productRepository = ProductRepository()
    private var _productList = MutableLiveData<List<Product>?>()

    val productList: LiveData<List<Product>?>
        get() = _productList

    init {
        products()
    }

    fun products() {
        productRepository.getProducts()
        _productList = productRepository.productList
    }

}
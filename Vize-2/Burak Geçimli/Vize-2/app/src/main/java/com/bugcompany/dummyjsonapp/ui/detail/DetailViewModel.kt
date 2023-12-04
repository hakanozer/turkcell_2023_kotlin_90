package com.bugcompany.dummyjsonapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bugcompany.dummyjsonapp.data.model.product.Product
import com.bugcompany.dummyjsonapp.data.source.repository.ProductRepository

class DetailViewModel(id: Int) : ViewModel() {
    val productRepository = ProductRepository()
    private var _productDetail = MutableLiveData<Product?>()

    val productDetail: LiveData<Product?>
        get() = _productDetail

    init {
        getProductById(id)
    }

    fun getProductById(id: Int) {
        productRepository.getProductById(id)
        _productDetail = productRepository.productDetail
    }

}

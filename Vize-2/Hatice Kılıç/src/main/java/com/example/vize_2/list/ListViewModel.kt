package com.example.vize_2.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.vize_2.model.ProductDetailInformation
import com.example.vize_2.repository.ProductRepository

class ListViewModel : ViewModel() {

    private val productRepository = ProductRepository()
    val productList: LiveData<List<ProductDetailInformation>?> get() = productRepository.productList

    fun getProductResponse() = productRepository.getProduct()

    fun getProductSearchResponse(searchQuery: String) = productRepository.searchProduct(searchQuery)
}
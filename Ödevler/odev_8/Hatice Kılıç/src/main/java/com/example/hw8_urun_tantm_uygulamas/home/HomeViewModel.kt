package com.example.hw8_urun_tantm_uygulamas.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw8_urun_tantm_uygulamas.model.ProductDetailInformation
import com.example.hw8_urun_tantm_uygulamas.repository.ProductRepository

class HomeViewModel : ViewModel() {

    private val productRepository = ProductRepository()
    val productList: LiveData<List<ProductDetailInformation>?> get() = productRepository.productList

    fun getProductResponse() = productRepository.getProduct()

    fun getProductSearchResponse(searchQuery: String) = productRepository.searchProduct(searchQuery)
}
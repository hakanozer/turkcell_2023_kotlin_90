package com.example.kotlinvize2.repository

import com.example.kotlinvize2.Network.ApiClient
import com.example.kotlinvize2.Network.service.DummyService
import com.example.kotlinvize2.model.Product
import com.example.kotlinvize2.model.Products

class DummyServiceRepository {
    //mvvm katmanına uygun olması için servise istek atan ayrı bir katman oluşturuldu
    private var dummyService: DummyService = ApiClient.getApiClient().create(DummyService::class.java)

    suspend fun getProducts() : Products {
        return dummyService.getProducts()
    }

    suspend fun searchProduct(query: String) : Products {
        return dummyService.searchProduct(query)
    }

    suspend fun getProductById(productId: String) : Product {
        return dummyService.getProductById(productId)
    }
}
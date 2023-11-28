package com.gorkemarslanbogan.ecommer1234.repository

import com.gorkemarslanbogan.ecommer1234.model.LoginResult
import com.gorkemarslanbogan.ecommer1234.model.Product
import com.gorkemarslanbogan.ecommer1234.model.Products
import com.gorkemarslanbogan.ecommer1234.model.UserLogin
import com.gorkemarslanbogan.ecommer1234.network.ApiClient
import com.gorkemarslanbogan.ecommer1234.network.services.DummyService

class DummyServiceRepository {
    private var dummyService: DummyService = ApiClient.getApiClient().create(DummyService::class.java)

    suspend fun login(userLogin: UserLogin) : LoginResult? {
       return dummyService.login(userLogin)
    }

    suspend fun getProducts() : Products {
        return dummyService.getProducts()
    }

    suspend fun searchProduct(query: String) : Products {
        return dummyService.searchProduct(query)
    }
}
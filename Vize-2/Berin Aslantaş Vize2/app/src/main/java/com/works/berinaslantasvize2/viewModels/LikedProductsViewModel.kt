package com.works.berinaslantasvize2.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LikedProductsViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences =
        application.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
    private val likedProductsKey = "likedProducts"

    private val _likedProducts = MutableLiveData<Set<String>>()
    val likedProducts: LiveData<Set<String>> get() = _likedProducts

    init {
        _likedProducts.value = getLikedProducts()
    }

    fun refreshLikedProducts() {
        _likedProducts.value = getLikedProducts()
    }

    private fun getLikedProducts(): Set<String> {
        return sharedPreferences.getStringSet(likedProductsKey, setOf()) ?: setOf()
    }
}

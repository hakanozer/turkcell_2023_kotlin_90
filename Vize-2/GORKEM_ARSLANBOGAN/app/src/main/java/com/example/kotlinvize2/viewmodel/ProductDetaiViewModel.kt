package com.example.kotlinvize2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinvize2.helper.shared.SHARED_KEY
import com.example.kotlinvize2.helper.shared.SharedManagment
import com.example.kotlinvize2.model.Product
import kotlinx.coroutines.launch

class ProductDetaiViewModel : ViewModel() {
    private val _productsIsFavorite = MutableLiveData<Boolean>()
    val productsIsFavorite: LiveData<Boolean> get() = _productsIsFavorite

    fun checkProductIsFavorite(productId: String){
        viewModelScope.launch {
            val productIds = SharedManagment.getMyFavoriteList(SHARED_KEY.SAVE_ALL_PRODUCT.name)
            productIds.forEach { id ->
                if(id.toString() == productId) {
                    _productsIsFavorite.postValue(true)
                }
            }
        }
    }

    fun addFavorite(product: Product) : Boolean {
        return SharedManagment.saveSingleProduct(product.id.toInt())
    }
}
package com.example.kotlinvize2.helper.shared

import android.content.Context
import android.content.SharedPreferences
import com.example.kotlinvize2.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SharedManagment {

    private var sharedPreferences: SharedPreferences? = null
    private var sharedEditor: SharedPreferences.Editor? = null
    private val gson: Gson by lazy { Gson() }
    fun getSharedInstance(context: Context) : SharedPreferences.Editor {
        if(sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("FavoriProduct", Context.MODE_PRIVATE)
        }
        if(sharedEditor == null) {
            sharedEditor = sharedPreferences!!.edit()
        }
        return sharedEditor!!
    }

    fun saveMyProductList(key: String, productList: List<Int>) {
        val jsonModel = gson.toJson(productList)
        sharedEditor?.putString(key, jsonModel)?.apply()
    }

    fun saveSingleProduct(productId: Int) : Boolean {
        val myFavoriList = getMyFavoriteList(SHARED_KEY.SAVE_ALL_PRODUCT.name)
        return try {
            myFavoriList.add(productId)
            saveMyProductList(SHARED_KEY.SAVE_ALL_PRODUCT.name, myFavoriList)
            true
        }catch (e: Exception){
            false
        }
    }

    fun getMyFavoriteList(key: String) : MutableList<Int> {
        val myFavoriListJson = sharedPreferences?.getString(key, "")
        if(!myFavoriListJson.isNullOrEmpty()){
            val type = object : TypeToken<MutableList<Int>>() {}.type
            return gson.fromJson(myFavoriListJson, type)
        }
        return mutableListOf()
    }
}

enum class SHARED_KEY {
    SAVE_ALL_PRODUCT
}
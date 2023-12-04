package com.works.berinaslantasvize2

import android.content.Context
import android.content.SharedPreferences

class LikedProductsData(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
    private val likedProductsKey = "likedProducts"

    fun getLikedProducts(): List<String> {
        val likedProductsSet: Set<String> =
            sharedPreferences.getStringSet(likedProductsKey, setOf()) ?: setOf()
        return likedProductsSet.toList()
    }
}

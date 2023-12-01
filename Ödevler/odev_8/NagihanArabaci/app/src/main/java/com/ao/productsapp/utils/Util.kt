package com.ao.productsapp.utils

import android.content.Context
import com.ao.productsapp.model.JWTUser
import com.google.gson.Gson

class Util {

    fun getUser(context: Context) : JWTUser? {
        val shared = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        val stUser =  shared.getString("user", "")
        if (stUser != "") {
            val gson = Gson()
            val user = gson.fromJson(stUser, JWTUser::class.java)
            return user
        }
        return null
    }

}
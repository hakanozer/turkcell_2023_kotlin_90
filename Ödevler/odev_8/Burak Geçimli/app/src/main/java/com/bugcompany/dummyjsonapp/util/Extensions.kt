package com.bugcompany.dummyjsonapp.util

import android.content.Context
import android.util.Log
import com.bugcompany.dummyjsonapp.data.model.user.JwtUser
import com.google.gson.Gson

//Extension fonksiyon olarak yazıldı.
fun Context.getShare(): JwtUser? {
    val shared = this.getSharedPreferences("users", Context.MODE_PRIVATE)

    val strUser = shared.getString("user", "")
    if (strUser != null) {
        val gson = Gson()
        val user = gson.fromJson(strUser, JwtUser::class.java)
        Log.d("users", strUser)
        return user
    }
    return null
}
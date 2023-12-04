package com.example.esmasalkim_vize2.utils

import android.content.Context
import com.example.esmasalkim_vize2.models.JWTUser
import com.google.gson.Gson


class Util {

    fun getUser(context: Context) : JWTUser? { // Activity ya da Context den miras almazsak oluşturduğumuz shared e ulaşamayız.
        val shared = context.getSharedPreferences("users", Context.MODE_PRIVATE)
        // burda editore ihtiyaç yok
        val stUser = shared.getString("user", "")

        // let: String bir ifadenin denetlenmesinden sonra kesinlikle it diye bir değişkenin oluştuğunu gösterir

        if (stUser != ""){
            //Log.d("users", stUser!!)
            val gson = Gson()
            val user = gson.fromJson(stUser, JWTUser::class.java)
            return user

        }
        return null
    }

}
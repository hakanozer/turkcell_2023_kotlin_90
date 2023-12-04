package com.ao.nagihanarabaci.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper {


    fun getSharedPreferences(context: Context, name: String): SharedPreferences {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    fun put(sharedPreferences: SharedPreferences, key: String, value: Any) {
        val editor = sharedPreferences.edit()

        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            is Boolean -> editor.putBoolean(key, value)
        }

        editor.commit()
    }

    fun getString(
        sharedPreferences: SharedPreferences,
        key: String,
        defaultValue: String
    ): String? {
        return sharedPreferences.getString(key, defaultValue)
    }




}


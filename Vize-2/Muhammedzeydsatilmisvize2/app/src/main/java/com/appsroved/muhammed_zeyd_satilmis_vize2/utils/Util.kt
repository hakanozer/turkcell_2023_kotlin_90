package com.appsroved.muhammed_zeyd_satilmis_vize2.utils

import android.content.Context
import android.view.View
import androidx.lifecycle.livedata.R
import com.appsroved.muhammed_zeyd_satilmis_vize2.models.Product
import com.bumptech.glide.Glide

class Util {

    fun getFavList(context: Context): MutableSet<String>? {
        val shared = context.getSharedPreferences("ids", Context.MODE_PRIVATE)
        val sId = shared.getStringSet("id", null)

        if (sId != null) {
            return sId
        }

        return null

    }

}

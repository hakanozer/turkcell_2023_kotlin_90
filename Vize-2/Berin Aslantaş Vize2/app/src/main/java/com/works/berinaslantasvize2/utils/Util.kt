package com.works.berinaslantasvize2.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

object Util {

    fun Fragment.showToast(message : String){
        Toast.makeText(this.context,message,Toast.LENGTH_LONG).show()
    }
}
package com.gorkemarslanbogan.ecommer1234.helper

import android.content.Context
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gorkemarslanbogan.ecommer1234.R

object Utils {

    const val INTENT_DATA_KEY = "product"

    fun showShortToast(context: Context, text: String){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

     fun checkEdittext(context: Context, edittextArray: List<EditText>) : Boolean {
        edittextArray.forEach {
            if(it.text.isBlank()) {
                it.error = context.getString(R.string.str_value_can_not_empty)
                return false
            }
        }
        return true
    }

    fun getImageByURL(context: Context ,imageUrl: String, imageView: ImageView) {
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.shopping)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }
}
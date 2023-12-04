package com.example.kotlinvize2.helper

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.kotlinvize2.R

object Utils {
    const val INTENT_DATA_KEY = "product"
    fun showShortToast(context: Context, text: String){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun getImageByURL(context: Context, imageUrl: String, imageView: ImageView) {
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_load_24)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }
}
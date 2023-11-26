package com.davutkarakus.turkcellgelecegiyazanlarodev8.Util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.davutkarakus.turkcellgelecegiyazanlarodev8.R
import com.davutkarakus.turkcellgelecegiyazanlarodev8.model.User
import com.google.gson.Gson

fun ImageView.downloadFromUrl(url:String?,progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_launcher_foreground)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun placeholderProgressBar(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        this.strokeWidth = 8f
        this.centerRadius = 40f
        start()
    }
}

fun getUser(context:Context) : User?{
    val shared = context.getSharedPreferences("users",Context.MODE_PRIVATE)
    val stUser = shared.getString("user","")

    if (stUser != ""){
        val gson = Gson()
        val user = gson.fromJson(stUser,User::class.java)
        return user
    }
    return null
}
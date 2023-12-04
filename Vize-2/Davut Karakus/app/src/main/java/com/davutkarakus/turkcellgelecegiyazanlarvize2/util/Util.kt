package com.davutkarakus.turkcellgelecegiyazanlarvize2.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.davutkarakus.turkcellgelecegiyazanlarvize2.R


fun ImageView.downloadFromUrl(url:String?, progressDrawable: CircularProgressDrawable) {
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

package com.example.odev8alimertkirecci

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class TanitimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanitim)
        val textView: TextView = findViewById(R.id.textViewaraba)

        val intent=intent
      val secilenarabaIsmi=  intent.getStringExtra("Arabaİsimleri")
        textView.text=secilenarabaIsmi
        val secilenarabaResim=intent.getIntExtra("Araba Resimleri",0)
       val bitmap=BitmapFactory.decodeResource(applicationContext.resources,secilenarabaResim)
        imageView.setImageBitmap(bitmap)
    }
}






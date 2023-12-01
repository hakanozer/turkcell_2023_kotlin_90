package com.works.homework_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.works.homework_8.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")
        val image = intent.getStringExtra("image")
        binding.titleTextView.text = title
        binding.descriptionTextView.text = price
    }
}
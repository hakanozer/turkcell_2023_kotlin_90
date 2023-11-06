package com.works.days_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.works.days_3.databinding.ActivityMainBinding
import com.works.days_3.databinding.ActivityProductBinding

class Product : AppCompatActivity() {

    private lateinit var binding : ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
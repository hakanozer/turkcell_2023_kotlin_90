package com.example.hw8_urun_tantm_uygulamas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw8_urun_tantm_uygulamas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
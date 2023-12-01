package com.nazlican.turkcellgelecegiyazanlarhomework8.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nazlican.turkcellgelecegiyazanlarhomework8.R
import com.nazlican.turkcellgelecegiyazanlarhomework8.common.viewBinding
import com.nazlican.turkcellgelecegiyazanlarhomework8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
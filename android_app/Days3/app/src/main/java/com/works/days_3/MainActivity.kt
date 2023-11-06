package com.works.days_3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.works.days_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtName.setText("")
        binding.btnProduct.setOnClickListener {
            val data = binding.txtName.text.toString()
            if (data.isEmpty()) {
                // alert
                Toast.makeText( applicationContext, "Data Empty!", Toast.LENGTH_LONG).show()
                Log.d("if", " call ")
            }else {
                val i = Intent(this, Product::class.java)
                startActivity(i)
            }

        }
    }

}
package com.example.begendigimurunleruygulamasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import com.example.begendigimurunleruygulamasi.databinding.ActivityMainBinding
import com.example.begendigimurunleruygulamasi.databinding.ActivityTanitimBinding

class tanitimActivity : AppCompatActivity() {
    lateinit var binding: ActivityTanitimBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanitim)
        val sharedprf=getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor=sharedprf.edit()
        binding.btnbgn.setOnClickListener {
            val price= binding.txtvwmyv.toString()
            editor.apply{
                putString("price",price)
                apply()
            }
        }


    }
}
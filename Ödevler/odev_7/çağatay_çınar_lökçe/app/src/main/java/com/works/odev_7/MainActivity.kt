package com.works.odev_7

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.works.odev_7.adapter.CustomAdapter
import com.works.odev_7.databinding.ActivityMainBinding
import com.works.odev_7.model.Weather
import com.works.odev_7.service.WeatherService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var array: List<Weather> = WeatherService().xml()
    var array2: List<Weather> = WeatherService().xml()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        fun refreshFun(isNew: Boolean){
            if (isNew){
                var adapter = CustomAdapter(this, array2)
                binding.lstWeather.adapter = adapter
            }else{
                var adapter = CustomAdapter(this, array)
                binding.lstWeather.adapter = adapter
            }
        }

        refreshFun(false)

        binding.srcText.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText != null && newText!=""){
                    array = array.filter {
                        it.il.contains(newText, true)
                    }
                    refreshFun(false)
                }else{
                    refreshFun(true)
                }
                array = array2
                return false
            }

        })
    }
}
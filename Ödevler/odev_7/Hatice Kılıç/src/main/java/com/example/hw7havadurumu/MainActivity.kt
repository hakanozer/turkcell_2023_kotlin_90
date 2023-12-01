package com.example.hw7havadurumu

import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw7havadurumu.adapter.WeatherAdapter
import com.example.hw7havadurumu.databinding.ActivityMainBinding
import com.example.hw7havadurumu.model.Weather
import com.example.hw7havadurumu.service.WeatherService

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WeatherAdapter
    private lateinit var weatherList: List<Weather>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        weatherList = WeatherService().getWeatherForecast()
        adapter = WeatherAdapter(weatherList)
        binding.recyclerView.adapter = adapter
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { searchKey(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { searchKey(it) }
                return true
            }
        })
    }

    private fun searchKey(text: String) {
        val queriedList = weatherList.filter {
            it.cityName.contains(text, ignoreCase = true)
        }
        adapter.getUpdate(queriedList)
    }
}


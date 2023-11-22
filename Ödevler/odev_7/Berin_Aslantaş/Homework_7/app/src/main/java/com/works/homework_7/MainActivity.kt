package com.works.homework_7


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.works.homework_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dummyWeatherList = generateDummyWeatherData()


        weatherAdapter = WeatherAdapter(dummyWeatherList)


        binding.list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = weatherAdapter
        }

    }

    private fun generateDummyWeatherData(): List<Weather> {
        val weatherList = mutableListOf<Weather>()

        return weatherList
    }

    private fun getFilteredWeatherList(): List<Weather> {

        return listOf()
    }
}

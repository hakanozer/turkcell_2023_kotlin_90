package com.works.weatherforecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import com.works.weatherforecast.adapters.WeatherAdapter
import com.works.weatherforecast.databinding.ActivityMainBinding
import com.works.weatherforecast.models.WeatherForecast
import com.works.weatherforecast.service.XmlResult

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: WeatherAdapter
    private lateinit var arrResult: List<WeatherForecast>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //layout içindeki listview atama
        listView = binding.listView
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val xmlResult = XmlResult()
        arrResult = xmlResult.xml()

        //adapter oluşturma ve lisview'e atama
        adapter = WeatherAdapter(this, arrResult)
        listView.adapter = adapter

        //dinleyici
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                //aramaya basıldığında klavye kapama temizleme işlemi
                binding.searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //arama metni değiştiğinde yenimetin üzerinde filtreleme
                //null değilse
                newText?.let { text ->
                    val filterList = arrResult.filter { weather ->
                        //küçük büyük harf duyarlılığı
                        weather.il.contains(text, ignoreCase = true)
                    }
                    //lisview güncelleme
                    adapter = WeatherAdapter(this@MainActivity, filterList)
                    listView.adapter= adapter

                }
                return true
            }

        } )
    }
}
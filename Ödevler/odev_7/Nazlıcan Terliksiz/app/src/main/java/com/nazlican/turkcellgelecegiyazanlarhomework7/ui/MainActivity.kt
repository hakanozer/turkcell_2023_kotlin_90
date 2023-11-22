package com.nazlican.turkcellgelecegiyazanlarhomework7.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.widget.SearchView
import com.nazlican.turkcellgelecegiyazanlarhomework7.databinding.ActivityMainBinding
import com.nazlican.turkcellgelecegiyazanlarhomework7.model.WeatherModel
import com.nazlican.turkcellgelecegiyazanlarhomework7.service.XmlResult
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: WeatherAdapter
    private lateinit var arrList: List<WeatherModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val xmlResult = XmlResult()
        arrList = xmlResult.xml()

        adapter = WeatherAdapter(arrList)
        binding.weatherListView.adapter = adapter

        search()
    }

    fun search() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText)
                return true
            }
        })
    }

    private fun filter(query: String) {
        if (query.isNotBlank()) {
            val filteredList = arrList.filter { it.il.toLowerCase(Locale.ROOT).contains(query) }
            adapter.submitList(filteredList)
        } else {
            adapter.submitList(arrList)
        }
    }
}
package com.davutkarakus.turkcellgelecegiyazanlarodev7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davutkarakus.turkcellgelecegiyazanlarodev7.adapter.WeatherAdapter
import com.davutkarakus.turkcellgelecegiyazanlarodev7.model.Weather

class MainActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var recyclerList : RecyclerView
    private lateinit var adapter: WeatherAdapter
    private lateinit var arrResult: List<Weather>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchView)
        recyclerList = findViewById(R.id.recyclerList)

        recyclerList.layoutManager = LinearLayoutManager(this)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val xmlResult = WeatherResult()
        arrResult = xmlResult.xml()
        adapter = WeatherAdapter(arrResult)
        recyclerList.adapter = adapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { filterData(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { filterData(it) }
                return true
            }
        })
    }

    private fun filterData(text: String) {
        val filteredList = arrResult.filter {
            it.countryName.contains(text, ignoreCase = true)
        }
        adapter.updateData(filteredList)
    }

}
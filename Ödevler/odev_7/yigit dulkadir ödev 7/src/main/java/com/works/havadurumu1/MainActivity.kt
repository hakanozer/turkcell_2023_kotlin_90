package com.works.havadurumu1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var weatherListView: ListView


    lateinit var listAdapter: ArrayAdapter<String>


    lateinit var weatherList: ArrayList<String>


    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        weatherListView = findViewById(R.id.idLVWeather)


        searchView = findViewById(R.id.idSV)


        weatherList = ArrayList()
        weatherList.add("Malatya - Bulutlu")
        weatherList.add("Ankara - Yağmurlu")
        weatherList.add("İstanbul - Parçalı bulutlu")
        weatherList.add("Hatay - Güneşli")
        weatherList.add("Trabzon - Kapalı")
        weatherList.add("Sivas - Karlı")
        weatherList.add("Kars - Karlı")
        weatherList.add("Yozgat - Sisli")
        weatherList.add("Antalya - Rüzgarlı")


        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            weatherList
        )


        weatherListView.adapter = listAdapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (weatherList.contains(query)) {
                    listAdapter.filter.filter(query)
                } else {
                    Toast.makeText(this@MainActivity, "Bulunamadı..", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                listAdapter.filter.filter(newText)

                return false
            }
        })
    }
}


package com.example.muhammed_zeyd_satilmis_odev7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muhammed_zeyd_satilmis_odev7.adapters.RecyclerCustomAdapter
import com.example.muhammed_zeyd_satilmis_odev7.databinding.ActivityMainBinding
import com.example.muhammed_zeyd_satilmis_odev7.models.WeatherModel
import com.example.muhammed_zeyd_satilmis_odev7.service.WeatherResult
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recAdapter: RecyclerCustomAdapter
    private lateinit var dataList: List<WeatherModel>


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        GlobalScope.launch(Dispatchers.IO) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)

            dataList = WeatherResult().getResult()

            launch(Dispatchers.Main) {
                //rec view ve search işlemlerini başlatmak için thread başlatma
                setupRecyclerView()
                searchData()
            }
        }
    }

    //recycler oluşturma
    private fun setupRecyclerView() {
        recAdapter = RecyclerCustomAdapter(dataList)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recAdapter
    }

    //Şehir arama için gerekli ovveride işlemleri
    private fun searchData() {
        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    filterList(newText)
                }
                return true
            }
        })

    }

    //Şehir filtreleme fonksiyonu
    private fun filterList(text: String) {
        val filteredList = mutableListOf<WeatherModel>()

        for (data in dataList) {
            val city = data.city.lowercase()
            if (city.contains(text.lowercase())) {
                (filteredList).add(data)
            }
            if (filteredList.isNotEmpty()) {
                recAdapter.setFilteredList(filteredList)
            }
        }
    }
}

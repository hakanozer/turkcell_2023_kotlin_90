package com.works.odev

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.works.odev.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var originalData: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Adapter ve ListView'ı ayarla
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        binding.listView.adapter = adapter

        // Coroutines'i kullanarak veriyi yükle
        loadData()

        // SearchView'ı ayarla
        binding.srchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { filterList(it) }
                return true
            }
        })
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val havaDurumuList = withContext(Dispatchers.IO) {
                    val hava = Hava()
                    hava.veri()
                }

                val result = havaDurumuList.map { it.toString() }
                originalData = result.toList() // Orijinal veriyi sakla

                adapter.clear()
                adapter.addAll(result)
                adapter.notifyDataSetChanged()
            } catch (ex: Exception) {
                ex.message?.let { Log.e("Hata", it) }
            }
        }
    }


    private fun filterList(query: String) {
        val filteredList = originalData.filter { it.contains(query, true) }
        adapter.clear()
        adapter.addAll(filteredList)
        adapter.notifyDataSetChanged()
    }


}


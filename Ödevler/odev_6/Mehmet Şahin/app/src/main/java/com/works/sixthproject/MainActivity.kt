package com.works.sixthproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listview)

        val pharmacyResult = PharmacyResult()

        lifecycleScope.launch {
            val adapter: ArrayAdapter<String> = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1)
            val infoPharmacy = withContext(Dispatchers.IO){
                pharmacyResult.gaziAntep()
            }.forEach{cities, pharmacyInfo ->
                adapter.add(cities)
                pharmacyInfo.forEach { pharmacy ->
                    adapter.add(pharmacy)
                }
            }
            listView.adapter = adapter
        }

    }
}


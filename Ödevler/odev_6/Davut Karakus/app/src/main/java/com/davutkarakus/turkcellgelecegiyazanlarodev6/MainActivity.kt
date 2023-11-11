package com.davutkarakus.turkcellgelecegiyazanlarodev6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: PharmacyAdapter
    private lateinit var pharmacyData: LinkedHashMap<String, MutableSet<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val run = Runnable {
            pharmacyData = EczaneResult().gaziAntep()
            runOnUiThread {
                listView = findViewById(R.id.listView)
                adapter = PharmacyAdapter(pharmacyData)
                listView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
        Thread(run).start()
    }
}

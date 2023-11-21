package com.example.odev_7

import android.os.Bundle
import android.os.Handler
import android.os.StrictMode
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.odev_7.adapters.MeteorolojiAdapter
import com.example.odev_7.models.Meteoroloji
import com.example.odev_7.service.XmlResult

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var searchView: SearchView
    private lateinit var originalList: List<Meteoroloji>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        searchView = findViewById(R.id.searchView)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val xmlResult = XmlResult()
        originalList = xmlResult.xml()

        val adapter = MeteorolojiAdapter(this, originalList)
        listView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            private val handler = Handler()
            private var currentQuery: String? = null

            private val filterRunnable = object : Runnable {
                override fun run() {
                    if (currentQuery != null && currentQuery!!.isNotEmpty()) {
                        adapter.filter.filter(currentQuery)
                    }
                }
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                handler.removeCallbacks(filterRunnable)
                if (newText != null && newText.isNotEmpty()) {
                    currentQuery = newText
                    handler.postDelayed(filterRunnable, 300)
                } else {
                    currentQuery = null
                    adapter.filter.filter(null)
                }
                return false
            }
        })
    }
}

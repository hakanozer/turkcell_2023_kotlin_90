package com.works.odev_7_

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ListView
import android.widget.SearchView
import com.works.odev_7_.adapters.HavaAdapter
import com.works.odev_7_.meteroloji.XmlResult
import com.works.odev_7_.model.sehirler

class MainActivity : AppCompatActivity() {

    lateinit var l_listView: ListView
    lateinit var s_searchView: SearchView
    lateinit var sehirlistesi: List<sehirler>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        l_listView = findViewById(R.id.l_listView)
        s_searchView = findViewById(R.id.s_searchView)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val xmlResult = XmlResult()
        val arrResult = xmlResult.xml()

        val adapter = HavaAdapter(this, arrResult)
        l_listView.adapter = adapter
    }

    fun searchData() {
        s_searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Thread.sleep(2000)
                return true;
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    listFiltre(newText)
                } else {

                    val xmlResult = XmlResult()
                    val arrResult = xmlResult.xml()
                    val adapter = HavaAdapter(this@MainActivity, arrResult)
                    l_listView.adapter = adapter
                }
                return true
            }
        })
    }

    fun listFiltre(text: String) {
        val listFiltre = mutableListOf<sehirler>()
        for (data in sehirlistesi) {
            val city = data.il.lowercase()
            if (city.contains(text)) {
                (listFiltre).add(data)
            }
        }
    }
}
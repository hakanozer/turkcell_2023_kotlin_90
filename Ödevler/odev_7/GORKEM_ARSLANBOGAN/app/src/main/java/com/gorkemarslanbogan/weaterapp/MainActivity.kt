package com.gorkemarslanbogan.weaterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.gorkemarslanbogan.weaterapp.adapter.WeaterAdapter
import com.gorkemarslanbogan.weaterapp.helper.WeaterManager
import com.gorkemarslanbogan.weaterapp.service.NetworkManager

class MainActivity : AppCompatActivity() {
    private lateinit var rcylerView: RecyclerView
    private lateinit var searView: androidx.appcompat.widget.SearchView
    private lateinit var weaterAdapter: WeaterAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setComponent()
        getAllDataThenSetAdapter()
        searView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                val filteredList = WeaterManager.getFilteredData(newText)
                weaterAdapter.updateWeatherData(filteredList)
                return true
            }
        })
    }

    fun setComponent(){
        rcylerView = findViewById(R.id.rc_weater)
        searView = findViewById(R.id.my_search_view)
    }
    fun getAllDataThenSetAdapter(){
        Thread {
            val weaterList = WeaterManager.getAllData()
            runOnUiThread {
                weaterAdapter = WeaterAdapter(weaterList)
                rcylerView.adapter = weaterAdapter
            }
        }.start()
    }
}
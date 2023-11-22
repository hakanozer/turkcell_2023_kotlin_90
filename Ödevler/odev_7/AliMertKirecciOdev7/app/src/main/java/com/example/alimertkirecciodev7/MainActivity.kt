package com.example.alimertkirecciodev7

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alimertkirecciodev7.Models.Currency
import com.example.alimertkirecciodev7.Service.XmlResult
import com.example.alimertkirecciodev7.adapter.CustomAdapter


class MainActivity : AppCompatActivity() {
lateinit var listView: ListView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.listViev)




        val policy=StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val xmlRESULT=XmlResult()
        xmlRESULT.xml()
        val arrResult= xmlRESULT.xml();
        val adapter=CustomAdapter(this,arrResult)
        listView.adapter=adapter


//        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,arr)
//   listView.adapter=adapter
    }

}
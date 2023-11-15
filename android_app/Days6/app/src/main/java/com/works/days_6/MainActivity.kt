package com.works.days_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ArrayAdapter
import android.widget.ListView
import com.works.days_6.adapters.CustomAdapter
import com.works.days_6.service.XmlResult

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    //val arr = listOf<String>("İstanbul", "İzmir", "Ankara", "Edirne", "Samsun", "Antalya", "Gaziantep")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val xmlResult = XmlResult()
        val arrResult = xmlResult.xml();

        val adapter = CustomAdapter(this, arrResult)
        listView.adapter = adapter
        //val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arr)
        //listView.adapter = adapter
    }


}
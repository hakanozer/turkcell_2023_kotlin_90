package com.works.odev_6_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    val list = ArrayList<String>()
    val arr = EczaneResult().gaziantep()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        for (i in arr){
            list.add(i.toString())
        }


        val arrayAdapter: ArrayAdapter<String> =ArrayAdapter(this,android.R.layout.activity_list_item,R.id.textView,list)
        listView.adapter=arrayAdapter

    }


}

package com.works.odev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var dataList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        dataList = ArrayList()


        Thread {
            val eczaneler = Eczaneler()
            val eczaneBilgileri = eczaneler.gaziantep()


            runOnUiThread {
                guncelle(eczaneBilgileri)
            }
        }.start()


    }

    fun guncelle(eczaneBilgileri: LinkedHashMap<String, MutableSet<String>>) {
        dataList.clear()

        for ((ilce, eczaneler) in eczaneBilgileri) {
            dataList.add(ilce)
            dataList.addAll(eczaneler)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
        listView.adapter = adapter
    }


}

package com.works.homework_6

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var Eczaneler: ArrayList<Eczane>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchDataAndPopulateListView()
    }

    private fun fetchDataAndPopulateListView() {
        val runnable = Runnable {
            val eczaneResult = EczaneResult()
            val eczaneData = eczaneResult.gaziAntep()

            Eczaneler = ArrayList()

            for ((district, pharmacyList) in eczaneData) {
                addEczanelerToArrayList(district, pharmacyList)
            }

            val groupedEczaneler = groupEczanelerByDistrict()
            val itemsWithHeaders = createItemsWithHeaders(groupedEczaneler)

            updateListViewOnUiThread(itemsWithHeaders)
        }

        Thread(runnable).start()
    }

    private fun addEczanelerToArrayList(district: String, eczaneList: MutableSet<String>) {
        eczaneList.forEach { eczaneItem ->
            val eczane = Eczane(district, eczaneItem)
            Eczaneler.add(eczane)
        }
    }

    private fun groupEczanelerByDistrict(): Map<String, List<Eczane>> {
        return Eczaneler.groupBy { it.locationName.toString() }
    }

    private fun createItemsWithHeaders(groupedEczaneler: Map<String, List<Eczane>>): List<Any> {
        val itemsWithHeaders = ArrayList<Any>()
        for ((district, eczaneList) in groupedEczaneler) {
            itemsWithHeaders.add(district)
            itemsWithHeaders.addAll(eczaneList)
        }
        return itemsWithHeaders
    }

    private fun updateListViewOnUiThread(itemsWithHeaders: List<Any>) {
        val handler = Handler(Looper.getMainLooper())

        handler.post {
            val listView = findViewById<ListView>(R.id.listview)
            val adapter = EczaneAdapter(this, itemsWithHeaders)
            listView.adapter = adapter
        }
    }
}


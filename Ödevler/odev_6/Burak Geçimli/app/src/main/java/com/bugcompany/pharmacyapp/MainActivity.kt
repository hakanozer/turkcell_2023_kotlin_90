package com.bugcompany.pharmacyapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var pharmacies: ArrayList<Pharmacy>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val run = Runnable {
            val arr = PharmacyResult().gaziAntep()
            pharmacies = ArrayList()

            val arrCopy = arr.toMutableMap()
            println(arrCopy.toString())

            for (entry in arrCopy) {
                val district = entry.key
                val pharmacyList = entry.value
                pharmacyList.forEach { pharmacyItem ->
                    val pharmacy = Pharmacy(district, pharmacyItem)
                    pharmacies.add(pharmacy)
                }
            }

            val groupedPharmacies = pharmacies.groupBy { it.district }
            val itemsWithHeaders = ArrayList<Any>()
            for ((district, pharmacyList) in groupedPharmacies) {
                itemsWithHeaders.add(district)
                itemsWithHeaders.addAll(pharmacyList)
            }

            // UI thread'de ListView'i güncellemek için bir Handler nesnesi oluşturduk.
            val handler = Handler(Looper.getMainLooper())

            // ListView'i günceller.
            handler.post {
                val listView = findViewById<ListView>(R.id.listview)
                val adapter = PharmacyAdapter(this, itemsWithHeaders)
                listView.adapter = adapter
            }
        }

        Thread(run).start()
    }

}

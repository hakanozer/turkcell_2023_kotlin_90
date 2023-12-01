package com.example.hw6_gaziantep_nobetci_eczaneler

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hw6_gaziantep_nobetci_eczaneler.adapter.PharmacyAdapter
import com.example.hw6_gaziantep_nobetci_eczaneler.common.Constants
import com.example.hw6_gaziantep_nobetci_eczaneler.model.PharmacyInfo
import com.example.hw6_gaziantep_nobetci_eczaneler.service.PharmacyService

class MainActivity : AppCompatActivity() {

    private lateinit var listViewDistrict: ListView
    private lateinit var textViewPharmacyDate: TextView
    private lateinit var pharmacyList: List<PharmacyInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewDistrict = findViewById(R.id.listViewDistrict)
        textViewPharmacyDate = findViewById(R.id.textViewPharmacyDate)

        val run = Runnable {
            pharmacyList = PharmacyService().getPharmacies()
            runOnUiThread {
                listViewDistrict.adapter = PharmacyAdapter(this, pharmacyList)

                if (Constants.date != null) {
                    textViewPharmacyDate.text = Constants.date
                }
            }
        }
        Thread(run).start()
    }
}
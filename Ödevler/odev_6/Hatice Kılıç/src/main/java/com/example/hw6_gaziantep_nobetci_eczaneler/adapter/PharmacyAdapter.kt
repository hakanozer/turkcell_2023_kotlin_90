package com.example.hw6_gaziantep_nobetci_eczaneler.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.hw6_gaziantep_nobetci_eczaneler.R
import com.example.hw6_gaziantep_nobetci_eczaneler.model.PharmacyInfo

class PharmacyAdapter(context: Context, pharmacyList: List<PharmacyInfo>) :
    ArrayAdapter<PharmacyInfo>(context, R.layout.layout_pharmacy_info, pharmacyList) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val pharmacies = getItem(position)
        val view =
            LayoutInflater.from(context).inflate(R.layout.layout_pharmacy_info, parent, false)
        val textViewDistrict: TextView = view.findViewById(R.id.textViewPharmacyInfo)
        textViewDistrict.text = pharmacies?.pharmaciesInfo

        return view
    }
}
package com.bugcompany.pharmacyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PharmacyAdapter(private val context: Context, items: List<Any>) :
    ArrayAdapter<Any>(context,0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val item = getItem(position)

        return when (item) {
            is String -> {
                val view = LayoutInflater.from(context).inflate(R.layout.pharmacy_header, parent, false)
                val textViewHeader = view.findViewById<TextView>(R.id.textViewHeader)
                textViewHeader.text = item
                view
            }

            is Pharmacy -> {
                val view = LayoutInflater.from(context).inflate(R.layout.pharmacy_card, parent, false)
                val textViewInfo = view.findViewById<TextView>(R.id.textViewPharmacyInfo)
                textViewInfo.text = item.info
                view
            }
            else -> {
                View(context)
            }
        }
    }
}





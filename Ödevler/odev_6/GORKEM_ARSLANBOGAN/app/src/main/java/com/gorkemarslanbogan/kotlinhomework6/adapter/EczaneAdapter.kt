package com.gorkemarslanbogan.kotlinhomework6.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.gorkemarslanbogan.kotlinhomework6.R
import com.gorkemarslanbogan.kotlinhomework6.model.NobetciEczane

class EczaneAdapter(context: Context, val eczaneList: List<NobetciEczane>) : ArrayAdapter<NobetciEczane>(context, R.layout.nobetci_eczane_listview_layout, eczaneList) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val eczane = getItem(position)
        val view: View = LayoutInflater.from(context).inflate(R.layout.nobetci_eczane_listview_layout, parent, false)
        val ilceTextView: TextView = view.findViewById(R.id.nobetci_eczane_bilgi)
        if(eczane!!.eczaneBilgileri.contains("NÖBETÇİ ECZANELER")) {
            ilceTextView.setBackgroundColor(context.getColor(R.color.darkGreen))
            ilceTextView.setTextColor(context.getColor(R.color.white))
        }

        ilceTextView.text = eczane.eczaneBilgileri

        return view
    }



}

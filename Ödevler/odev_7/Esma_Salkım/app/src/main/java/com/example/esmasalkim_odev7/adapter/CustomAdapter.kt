package com.example.esmasalkim_odev7.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.esmasalkim_odev7.R
import com.example.esmasalkim_odev7.models.sehirler


class CustomAdapter (private val context : Activity, private val list: List<sehirler>)
        :
        ArrayAdapter<sehirler>(context, R.layout.item, list)
    {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val rootView = context.layoutInflater.inflate(R.layout.item, null, true)
            // veriyi listview de gösterme
            val item = list.get(position)

            val r_ili = rootView.findViewById<TextView>(R.id.r_ili)
            val r_durum = rootView.findViewById<TextView>(R.id.r_durum)
            val r_mak = rootView.findViewById<TextView>(R.id.r_mak)
            val r_min = rootView.findViewById<TextView>(R.id.r_min)


            r_ili.text = "İl : ${ item.il }"
            r_durum.text = "Durum : ${ item.durum }"
            r_mak.text = "Maks : ${ item.maks }"
            r_min.text = "Min : ${ item.min }"

            return rootView
        }

}
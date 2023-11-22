package com.works.odev_7_.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.works.odev_7_.R
import com.works.odev_7_.model.sehirler

class HavaAdapter(private val context: Activity, private val list: List<sehirler>)
    :
    ArrayAdapter<sehirler>(context, R.layout.hava_durumu,list)
{
    @SuppressLint("CutPasteId", "ViewHolder", "SetTextI18n", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.hava_durumu,null,true)
        val item = list.get(position)

        val txt_bolge = rootView.findViewById<TextView>(R.id.txt_bolge)
        txt_bolge.text = ("${item.bolge} Bölgesi")
        val txt_ili = rootView.findViewById<TextView>(R.id.txt_ili)
        txt_ili.text = item.il
        val txt_durum = rootView.findViewById<TextView>(R.id.txt_durum)
        txt_durum.text = item.durum
        val txt_maks = rootView.findViewById<TextView>(R.id.txt_maks)
        txt_maks.text = ("En Yüksek Hava Sıcaklığı :  ${item.maks} °C")
        val txt_min = rootView.findViewById<TextView>(R.id.txt_min)
        txt_min.text = ("En Düşük Hava Sıcaklığı :  ${item.min} °C")

        return rootView
    }

}


package com.example.alimertkirecciodev7.adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.alimertkirecciodev7.Models.Currency
import com.example.alimertkirecciodev7.R

class CustomAdapter (private val context: Activity,private val list: List<Currency>):
ArrayAdapter<Currency>(context,R.layout.custom_item,list)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       val rootView=context.layoutInflater.inflate(R.layout.custom_item,null,true)//root viewden geri dönecek elemanları temsil ediyor.
     val item=list.get(position)
        val r_sehirlerName=rootView.findViewById<TextView>(R.id.r_sehirlerName)
        val r_Bolge=rootView.findViewById<TextView>(R.id.r_Bolge)
        val r_Durum=rootView.findViewById<TextView>(R.id.r_Durum)
        val r_MaxDerece=rootView.findViewById<TextView>(R.id.r_maxderece)
        val r_MinDerece=rootView.findViewById<TextView>(R.id.r_minderece)
        val r_Peryot=rootView.findViewById<TextView>(R.id.r_Peryot)
        r_sehirlerName.text=item.sehirler
        r_Bolge.text=item.Bolge
        r_Durum.text=item.Durum
        r_MaxDerece.text="Maximum Sıcaklık:${item.MaxDerece}°C"
        r_MinDerece.text="Minimum Sıcaklık:${item.Minderece}°C"
        r_Peryot.text=item.Peryot

        return rootView
    }
    }


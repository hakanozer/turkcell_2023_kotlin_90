package com.example.odev_6

import android.graphics.Color
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class EczaneAdapter(private val eczaneData: LinkedHashMap<String, MutableSet<String>>) : BaseAdapter() {
    private val sectionHeaders = ArrayList<String>()
    private val eczanes = ArrayList<MutableList<String>>()
    init {
        for (ilce in eczaneData.keys) {
            sectionHeaders.add(ilce)
            val eczaneList = eczaneData[ilce]!!.sorted()
            eczanes.add(eczaneList.toMutableList())
        }
    }
    override fun getCount(): Int {
        return sectionHeaders.size + eczanes.size
    }
    override fun getItem(position: Int): Any {
        return if (position % 2 == 0) {
            sectionHeaders[position / 2]
        } else {
            val eczaneIndex = (position - 1) / 2
            eczanes[eczaneIndex]
        }
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getViewTypeCount(): Int {
        return 2
    }
    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) 0 else 1
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemType = getItemViewType(position)
        val layoutResId = if (itemType == 0) R.layout.eczane_section_item else R.layout.eczane_item
        val view = convertView ?: LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        if (itemType == 0) {
            val sectionTitle = view.findViewById<TextView>(R.id.eczane_section_title)
            if (getItem(position) is String) {
                val section = getItem(position) as String
                sectionTitle.text = section
                sectionTitle.setTextColor(Color.BLACK)
                sectionTitle.setBackgroundResource(android.R.color.transparent)
            }
        } else {
            val eczaneTitle = view.findViewById<TextView>(R.id.eczane_title)
            if (getItem(position) is ArrayList<*>) {
                val eczaneList = getItem(position) as ArrayList<*>
                if (eczaneList.isNotEmpty() && eczaneList[0] is String) {
                    val eczane = eczaneList[0] as String
                    if (eczaneTitle != null) {
                        eczaneTitle.text = eczane
                        view.findViewById<TextView>(R.id.eczane_adres).visibility = View.GONE
                        view.findViewById<TextView>(R.id.eczane_telefon).visibility = View.GONE
                    }
                }
            }
        }
        return view
    }

}


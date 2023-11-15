package com.works.homework_6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class EczaneAdapter(private val context: Context, items: List<Any>) :
    ArrayAdapter<Any>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val item = getItem(position)

        return when (item) {
            is String -> inflateHeader(item, parent)
            is Eczane -> inflateEczaneCard(item, parent)
            else -> View(context)
        }
    }

    private fun inflateHeader(headerText: String, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.eczane_header, parent, false)
        val textViewHeader = view.findViewById<TextView>(R.id.textViewHeader)
        textViewHeader.text = headerText
        return view
    }

    private fun inflateEczaneCard(eczane: Eczane, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.eczane_list, parent, false)
        val textViewInfo = view.findViewById<TextView>(R.id.textViewEczanelerInfo)
        textViewInfo.text = eczane.eczaneInfo
        return view
    }
}

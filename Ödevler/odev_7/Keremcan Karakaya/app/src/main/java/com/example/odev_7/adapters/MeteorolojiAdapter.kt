package com.example.odev_7.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.example.odev_7.R
import com.example.odev_7.models.Meteoroloji

class MeteorolojiAdapter(private val context: Activity, private var list: List<Meteoroloji>)
    : ArrayAdapter<Meteoroloji>(context, R.layout.custom_item, list), Filterable {

    private var filteredList: List<Meteoroloji> = list

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = context.layoutInflater.inflate(R.layout.custom_item, parent, false)
        }
        val item = if (position < filteredList.size) filteredList[position] else return view!!

        val bolgeTextView = view!!.findViewById<TextView>(R.id.bolgeTextView)
        val ilTextView = view.findViewById<TextView>(R.id.ilTextView)
        val durumTextView = view.findViewById<TextView>(R.id.durumTextView)
        val maxSicaklikTextView = view.findViewById<TextView>(R.id.maxSicaklikTextView)
        val minSicaklikTextView = view.findViewById<TextView>(R.id.minSicaklikTextView)

        bolgeTextView.text = " ${item.bolge} Bölgesi"
        ilTextView.text = " ${item.il}"
        durumTextView.text = " ${item.durum}"
        maxSicaklikTextView.text = " Maksimum Sıcaklık: ${item.maxSicaklik} C°"
        minSicaklikTextView.text = " Minimum Sıcaklık: ${item.minSicaklik}  C°"
        return view
    }
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val results = FilterResults()
                if (constraint.isNullOrEmpty()) {
                    results.values = list
                } else {
                    val filtered = list.filter {
                        it.il.contains(constraint!!, ignoreCase = true)
                    }
                    val uniqueList = filtered.distinctBy { it.il }
                    results.values = uniqueList
                }
                return results
            }
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<Meteoroloji>
                notifyDataSetChanged()
            }
        }
    }
    override fun getCount(): Int {
        return filteredList.size
    }
}
package com.davutkarakus.turkcellgelecegiyazanlarodev6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

 class PharmacyAdapter(private val data: LinkedHashMap<String, MutableSet<String>>) : BaseAdapter() {
     private val itemList = ArrayList<Any>()

     companion object {
         private const val TYPE_HEADER = 0
         private const val TYPE_ITEM = 1
     }

     init {
         for ((key, value) in data) {
             itemList.add(key)
             itemList.addAll(value)
         }
     }
     override fun getItemViewType(position: Int): Int {
         val item = getItem(position)
          if (item is String && data.containsKey(item)){
              return TYPE_HEADER
          }
          else {
              return TYPE_ITEM
          }
     }

     override fun getViewTypeCount(): Int {
         return 2
     }

     override fun getCount(): Int = itemList.size

     override fun getItem(position: Int): Any = itemList[position]

     override fun getItemId(position: Int): Long = position.toLong()

     override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
         val holder: ViewHolder
         val view: View
         val type = getItemViewType(position)
         if (convertView == null) {
             holder = ViewHolder()

             if (type == TYPE_HEADER) {
                 view = LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                 holder.headerTextView = view.findViewById(R.id.tvHeader)
             } else {
                 view = LayoutInflater.from(parent.context).inflate(R.layout.item_pharmacy, parent, false)
                 holder.itemTextView = view.findViewById(R.id.pharmacyItem)
             }
             view.tag = holder
         } else {
             holder = convertView.tag as ViewHolder
             view = convertView
         }

         val item = getItem(position)

         if (item is String && data.containsKey(item)) {
             holder.headerTextView.text = item
         } else if (item is String) {
             holder.itemTextView.text = item
         }
         return view
     }
 }



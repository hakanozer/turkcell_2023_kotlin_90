package com.works.berinaslantasvize2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.works.berinaslantasvize2.R

class LikedProductAdapter(context: Context, resource: Int, products: List<String>) :
    ArrayAdapter<String>(context, resource, products) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.liked_products_list_item, parent, false)

        val productNameTextView = rowView.findViewById<TextView>(R.id.txtProductTitle)
        productNameTextView.text = getItem(position)

        return rowView
    }
}




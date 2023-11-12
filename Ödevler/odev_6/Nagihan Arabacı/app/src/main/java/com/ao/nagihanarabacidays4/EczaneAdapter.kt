package com.ao.nagihanarabacidays4

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.ao.nagihanarabacidays4.databinding.ListItemBinding
import com.ao.nagihanarabacidays4.databinding.ListItemDetailBinding

class EczaneAdapter(private var context: Context, private var list: List<EczaneModel>) :
    ArrayAdapter<EczaneModel>(context, R.layout.list_item, list) {

    override fun getCount(): Int {
        return list.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = ListItemBinding.inflate(LayoutInflater.from(context), parent, false).root
        val item = getItem(position)
        val textView = itemView.findViewById<TextView>(R.id.headerTextView)
        val linearLayout = itemView.findViewById<LinearLayout>(R.id.detailItems)

        textView?.text = item?.name
        item?.eczaneDetails?.forEach {
            linearLayout.addView(
                ListItemDetailBinding.inflate(
                    LayoutInflater.from(context),
                    parent,
                    false
                ).root.apply {
                    findViewById<TextView>(R.id.detailTextView).text =
                        if (it.contains("ECZANESİ")) it.replace(
                            "ECZANESİ ",
                            "ECZANESİ\n"
                        ) else it.replace("ECZANESI ", "ECZANESİ\n")
                })
        }
        return itemView
    }
}
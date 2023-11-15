package com.works.days_6.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.works.days_6.R
import com.works.days_6.models.Currency

class CustomAdapter(private val context: Activity, private val list: List<Currency>)
    :
    ArrayAdapter<Currency>(context, R.layout.custom_item, list)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.custom_item, null, true)
        val item = list.get(position)

        val r_currencyName = rootView.findViewById<TextView>(R.id.r_currencyName)
        val r_forexBuying = rootView.findViewById<TextView>(R.id.r_forexBuying)
        val r_forexSelling = rootView.findViewById<TextView>(R.id.r_forexSelling)
        val r_banknoteBuying = rootView.findViewById<TextView>(R.id.r_banknoteBuying)
        val r_banknoteSelling = rootView.findViewById<TextView>(R.id.r_banknoteSelling)
        r_currencyName.text = item.currencyName
        r_forexBuying.text = "Forex: ${item.forexBuying}"
        r_forexSelling.text = "Forex: ${item.forexSelling}"
        r_banknoteBuying.text = "Bank: ${item.banknoteBuying}"
        r_banknoteSelling.text = "Bank: ${item.banknoteSelling}"

        return rootView
    }

}
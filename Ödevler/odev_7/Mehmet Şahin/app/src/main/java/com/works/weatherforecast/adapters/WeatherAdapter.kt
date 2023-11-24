package com.works.weatherforecast.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.forEach
import com.works.weatherforecast.R
import com.works.weatherforecast.models.WeatherForecast

open class WeatherAdapter(
    private val context: Activity,
    private var list: List<WeatherForecast>
) : ArrayAdapter<WeatherForecast>(
    context,
    R.layout.activity_main,
    list
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.weather, null, true)
        val item = list.get(position)
        val bolge = rootView.findViewById<TextView>(R.id.bolgeTxt)
        val il = rootView.findViewById<TextView>(R.id.ilTxt)
        val durum = rootView.findViewById<TextView>(R.id.durumTxt)
        val maxSicaklik = rootView.findViewById<TextView>(R.id.maxSicaklikTxt)
        val minSicaklik = rootView.findViewById<TextView>(R.id.minSicaklikTxt)

        bolge.text = "${item.bolge}  Bölgesi"
        il.text = item.il
        durum.text = item.durum
        //Değerler bazen boş gelmekte, boş görünmesi yerine bu görünümde olsun "--"
        maxSicaklik.text =
            if (item.maxSicaklik.isNotEmpty()) "Maksimum Sicaklik: ${item.maxSicaklik}" else "Maksimum Sicaklik: --"
        minSicaklik.text =
            if (item.minSicaklik.isNotEmpty()) "Minimum Sicaklik: ${item.minSicaklik}" else "Minimum Sicaklik: --"

        return rootView
    }

}
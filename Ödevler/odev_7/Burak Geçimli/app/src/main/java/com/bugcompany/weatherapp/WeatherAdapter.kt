package com.bugcompany.weatherapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugcompany.weatherapp.databinding.WeatherCardBinding

//  Recyclerview'i anlattığım medium yazısı linki.
//  https://medium.com/@burakgecimli444/recyclerview-ve-adapter-nedir-30d8717de2cf

class WeatherAdapter(private var weatherList: List<Weather>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherCardViewHolder>() {

    class WeatherCardViewHolder(val binding: WeatherCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherCardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = WeatherCardBinding.inflate(layoutInflater, parent, false)
        return WeatherCardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
    override fun onBindViewHolder(holder: WeatherCardViewHolder, position: Int) {
        val weather = weatherList[position]

        holder.binding.apply {
            txtRegion.text = weather.region
            txtPeriod.text = weather.period
            txtCity.text = weather.city
            txtMax.text = "En yüksek ${weather.maxTemp}°C"
            txtMin.text = "En düşük ${weather.minTemp}°C"
            txtStatus.text = weather.status
        }
    }

    fun setFilteredList(weatherList: List<Weather>) {
        this.weatherList = weatherList
        notifyDataSetChanged()
    }

}
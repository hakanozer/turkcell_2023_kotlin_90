package com.example.hw7havadurumu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw7havadurumu.databinding.RecyclerViewRowBinding
import com.example.hw7havadurumu.model.Weather

class WeatherAdapter(private var weatherList:List<Weather>):RecyclerView.Adapter<WeatherAdapter.WeatherHolder>() {
    class WeatherHolder(val binding:RecyclerViewRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = RecyclerViewRowBinding.inflate(inflater,parent,false)
        return WeatherHolder(view)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.binding.cityName.text = "City : ${(weatherList[position].cityName)}"
        holder.binding.cityInformation.text ="Information : ${(weatherList[position].cityInformation)}"
        holder.binding.cityWeatherMax.text = "Weather Maximum : ${(weatherList[position].cityWeatherMax)}"
        holder.binding.cityWeatherMin.text = "Weather Minumum : ${(weatherList[position].cityWeatherMin)}"
    }

    fun getUpdate(newList:List<Weather>){
        weatherList = newList
        notifyDataSetChanged()
    }


}
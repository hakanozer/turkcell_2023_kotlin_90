package com.works.homework_7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.works.homework_7.databinding.WeatherCardBinding

class WeatherAdapter(private var weatherList: List<Weather>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherCardViewHolder>() {

    inner class WeatherCardViewHolder(private val binding: WeatherCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: Weather) {
            binding.apply {
                with(weather) {
                    txtCity.text = city
                    txtMax.text = "En yüksek $maxTemp°C"
                    txtMin.text = "En düşük $minTemp°C"
                    txtStatus.text = status
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherCardViewHolder {
        val binding = WeatherCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeatherCardViewHolder(binding)
    }

    override fun getItemCount(): Int = weatherList.size

    override fun onBindViewHolder(holder: WeatherCardViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    fun updateData(newWeatherList: List<Weather>) {
        weatherList = newWeatherList
        notifyDataSetChanged()
    }

    fun getItemAtPosition(position: Int): Weather = weatherList[position]
}

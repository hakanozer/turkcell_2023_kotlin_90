package com.nazlican.turkcellgelecegiyazanlarhomework7.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nazlican.turkcellgelecegiyazanlarhomework7.databinding.ItemWeatherBinding
import com.nazlican.turkcellgelecegiyazanlarhomework7.model.WeatherModel

class WeatherAdapter(private val weatherList: List<WeatherModel>) :
    ListAdapter<WeatherModel, WeatherAdapter.WeatherViewHolder>(WeatherDiffUtilCallBack()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherAdapter.WeatherViewHolder {
        return WeatherViewHolder(
            ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) =
        holder.bind(getItem(position))

    class WeatherViewHolder(
        private val binding: ItemWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: WeatherModel) {
            with(binding) {
                ilTv.text = weather.il
                minSicaklik.text = "${weather.min}°C"
                maxSicaklik.text = "${weather.max}°C"
            }
        }
    }

    class WeatherDiffUtilCallBack : DiffUtil.ItemCallback<WeatherModel>() {
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem.il == newItem.il
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }
    }
}
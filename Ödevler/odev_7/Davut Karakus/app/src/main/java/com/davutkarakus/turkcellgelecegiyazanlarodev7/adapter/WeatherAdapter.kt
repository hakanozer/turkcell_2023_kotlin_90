package com.davutkarakus.turkcellgelecegiyazanlarodev7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davutkarakus.turkcellgelecegiyazanlarodev7.databinding.RecyclerRowBinding
import com.davutkarakus.turkcellgelecegiyazanlarodev7.model.Weather

class WeatherAdapter(private var weatherList:List<Weather>): RecyclerView.Adapter<WeatherAdapter.RvHolder>(){
    class RvHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view = RecyclerRowBinding.inflate(inflater,parent,false)
        return RvHolder(view)
    }

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        holder.binding.countryNameText.text = weatherList[position].countryName
        holder.binding.weatherDescripText.text = weatherList[position].weatherDescription
        holder.binding.tempMaxText.text = "${weatherList[position].tempMax}°C"
        holder.binding.tempMinText.text = "${weatherList[position].tempMin}°C"
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    fun updateData(newData: List<Weather>) {
        weatherList = newData
        notifyDataSetChanged()
    }
}
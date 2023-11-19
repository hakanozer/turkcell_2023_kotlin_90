package com.gorkemarslanbogan.weaterapp.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gorkemarslanbogan.weaterapp.R
import com.gorkemarslanbogan.weaterapp.model.WeatherModel

class WeaterAdapter(private var weaterList: List<WeatherModel>) : RecyclerView.Adapter<WeaterAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val city = view.findViewById<TextView>(R.id.textViewCity)
        val havaDurumu = view.findViewById<TextView>(R.id.textViewHavaDurumu)
        val minSicaklik = view.findViewById<TextView>(R.id.textViewMinSıcaklık)
        val maxSicaklik = view.findViewById<TextView>(R.id.textViewMaxSıcaklık)
        val perYot = view.findViewById<TextView>(R.id.textViewPeryot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weater_adapter_ui, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weatherModel = weaterList[position]
        holder.apply {
            city.text = weatherModel.il
            perYot.text = "${holder.itemView.context.getText(R.string.peryot)} ${weatherModel.peryot}"
            havaDurumu.text = "${holder.itemView.context.getText(R.string.durum)} ${weatherModel.durum}"
            maxSicaklik.text = "${holder.itemView.context.getText(R.string.max_sicaklik)} ${weatherModel.maxSicaklik}"
            minSicaklik.text = "${holder.itemView.context.getText(R.string.min_sicaklik)} ${weatherModel.minSicaklik}"
        }
    }

    override fun getItemCount(): Int {
        return weaterList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateWeatherData(weaterList: List<WeatherModel>) {
        this.weaterList = weaterList
        notifyDataSetChanged()
    }
}
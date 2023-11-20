package com.example.muhammed_zeyd_satilmis_odev7.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.muhammed_zeyd_satilmis_odev7.R
import com.example.muhammed_zeyd_satilmis_odev7.databinding.RecLayoutBinding
import com.example.muhammed_zeyd_satilmis_odev7.models.WeatherModel


class RecyclerCustomAdapter(private var dataList: List<WeatherModel>) :
    RecyclerView.Adapter<RecyclerCustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemViewBinding = RecLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemViewBinding)

    }

    fun setFilteredList(filteredList: List<WeatherModel>) {
        //filtreleme işlemi için ekstra fonksiyon
        this.dataList = filteredList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        //veri sayısı
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        //view ile datayı eşlemek için gerekli işlemler
        holder.rVCityTxt.text = currentItem.city
        holder.rVDayTimeTxt.text = currentItem.dayPeriod
        holder.rVRegionTxt.text = currentItem.region
        holder.rVInfoTxt.text = currentItem.info
        holder.rVMinTxt.text = "${currentItem.min}°C"
        holder.rVMaxTxt.text = "${currentItem.mak}°C"

        //veriyi kontrol etmek için fonksiyon
        fun isContains(txt: String, contain: String): Boolean {
            return txt.contains(contain)
        }
        //image değişimi için gerekli sorgular
        val isCloud = isContains(currentItem.info, "bulut")
        val isRain = isContains(currentItem.info, "yağmur")
        val isSnow = isContains(currentItem.info, "kar")
        val isAir = isContains(currentItem.info, "rüzgar")


//if else döngüsü hava durumu datasından gelen verilere göre ui içindeki hava durumu imagesini değiştirecek
        if (isRain) {
            holder.rVWeatherImg.setImageDrawable(
                ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.rain
                )
            )
        } else if (isSnow) {
            holder.rVWeatherImg.setImageDrawable(
                ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.snow
                )
            )
        } else if (isAir) {
            holder.rVWeatherImg.setImageDrawable(
                ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.air
                )
            )
        } else {
            holder.rVWeatherImg.setImageDrawable(
                ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.sun
                )
            )
        }


//aynı şekilde akşam veya sabah olma duruma göre image değişimi / from drawable
        if (currentItem.dayPeriod.lowercase() == "aksam") {
            holder.rVDayTimeImg.setImageDrawable(
                ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.night
                )
            )
        } else {
            holder.rVDayTimeImg.setImageDrawable(
                ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.day
                )
            )
        }


    }


    class ViewHolder(private val binding: RecLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //view için xml dosyasını eşleştirme
        val rVWeatherImg: ImageView = binding.imgWeather
        val rVDayTimeImg: ImageView = binding.imgDaytime
        val rVCityTxt: TextView = binding.txtCity
        val rVDayTimeTxt: TextView = binding.txtDaytime
        val rVRegionTxt: TextView = binding.txtRegion
        val rVMinTxt: TextView = binding.txtMin
        val rVMaxTxt: TextView = binding.txtMax
        val rVInfoTxt: TextView = binding.txtInfo

    }
}

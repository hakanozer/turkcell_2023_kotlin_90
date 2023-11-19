package com.gorkemarslanbogan.weaterapp.service

import android.util.Log
import com.gorkemarslanbogan.weaterapp.model.WeatherModel

object DataParser : IDataParser {
    //burada servisten gelen dataları modele göre ayarlayıp listemize ekliyoruz.
    //solid tek sorumululuk ilkesine uyuyoruz bu sınıfın tek amacı ilgili
    //datayı istediğimiz modele göre uyarlayıp verileri almaktır.
    override fun weatherDataParser(): List<WeatherModel> {
        val cities = NetworkManager.getWeaterOfCity()
        val weaterList: MutableList<WeatherModel> by lazy { mutableListOf() }
        if(!cities.isNullOrEmpty()) {
            cities.forEach {
                val peryot = it.getElementsByTag("Peryot").text()
                val il = it.getElementsByTag("ili").text()
                val durum = it.getElementsByTag("Durum").text()
                val maxSicaklik = it.getElementsByTag("Mak").text()
                val minSicaklik = it.getElementsByTag("Min").text()
                val weatherModel = WeatherModel(peryot, il, durum, maxSicaklik, minSicaklik)
                weaterList.add(weatherModel)
            }
        }
        return weaterList
    }

}
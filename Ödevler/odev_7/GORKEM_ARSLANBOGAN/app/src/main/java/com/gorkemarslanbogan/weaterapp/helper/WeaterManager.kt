package com.gorkemarslanbogan.weaterapp.helper

import android.util.Log
import com.gorkemarslanbogan.weaterapp.model.WeatherModel
import com.gorkemarslanbogan.weaterapp.service.DataParser
import com.gorkemarslanbogan.weaterapp.service.NetworkManager

object WeaterManager : IWeaterManager {
    // buradaki sınıfın tek amacı gelen datayı almak ve filtrelemektir.

    //by lazy ilk çağırıldığı yerde servise istek atar bu yöntemle gereksiz bellek kullanımının önüne geçilir.
    private val weaterOfCityList: List<WeatherModel> by lazy {
        DataParser.weatherDataParser()
    }

    override fun getAllData(): List<WeatherModel> {
        return weaterOfCityList
    }

    override fun getFilteredData(text: String): List<WeatherModel> {
        //eğer listenin içinde varsa ilgili değeri döndürür yoksa bütün listeyi döndürür.
        return if(text.isNotBlank()) {
            weaterOfCityList.filter { it.il.contains(text, ignoreCase = true) }
        }else {
            getAllData()
        }
    }


}
package com.gorkemarslanbogan.weaterapp.helper

import com.gorkemarslanbogan.weaterapp.model.WeatherModel


//interfaceler ile ilgili sınıfın doldurması gereken fonksiyonları tanımlıyoruz.
interface IWeaterManager {
    fun getAllData() : List<WeatherModel>
    fun getFilteredData(text:String) : List<WeatherModel>
}
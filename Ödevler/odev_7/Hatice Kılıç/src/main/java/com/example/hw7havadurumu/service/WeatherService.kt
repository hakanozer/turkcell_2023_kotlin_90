package com.example.hw7havadurumu.service


import android.util.Log
import com.example.hw7havadurumu.model.Weather
import org.jsoup.Jsoup
import org.jsoup.parser.Parser

class WeatherService {

    companion object{
        private const val URL = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
        private const val TIME_OUT = 15000
    }

    fun getWeatherForecast() : List<Weather>{
        val weatherList = mutableListOf<Weather>()
        try {
            val weatherData = Jsoup.connect(URL).ignoreContentType(true).timeout(TIME_OUT).get().toString()
            val weatherParser = Jsoup.parse(weatherData, Parser.xmlParser()).getElementsByTag("sehirler")
            for (i in weatherParser) {
                val cityName = i.getElementsByTag("ili").text()
                val cityInformation = i.getElementsByTag("Durum").text()
                val cityWeatherMax = i.getElementsByTag("Mak").text()
                val cityWeatherMin = i.getElementsByTag("Min").text()
                weatherList.add(Weather(cityName,cityInformation,cityWeatherMax,cityWeatherMin))
            }
        }catch (e:Exception) {
            Log.e("Error",e.toString())
        }
        return weatherList
    }
}
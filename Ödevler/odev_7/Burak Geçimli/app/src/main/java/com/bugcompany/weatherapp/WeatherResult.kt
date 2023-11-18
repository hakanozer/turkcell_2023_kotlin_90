package com.bugcompany.weatherapp

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class WeatherResult {

    fun getData(): List<Weather> {
        val arr = arrayListOf<Weather>()
        try {
            val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            val weatherStrData =
                Jsoup.connect(url).ignoreContentType(true).timeout(10000).get().toString()

            val doc: Document = Jsoup.parse(weatherStrData, Parser.htmlParser())
            val elementS: Elements = doc.getElementsByTag("sehirler")

            elementS.forEach { item ->
                val region = item.getElementsByTag("Bolge").text()
                val period = item.getElementsByTag(" Peryot").text()
                val city = item.getElementsByTag("ili").text()
                val maxTemp = item.getElementsByTag("Mak").text()
                val minTemp = item.getElementsByTag("Min").text()
                val status = item.getElementsByTag("Durum").text()

                val weather = Weather(region, period, city, maxTemp, minTemp, status)
                arr.add(weather)
            }
           // Log.e("Data", weatherStrData)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return arr
    }
}
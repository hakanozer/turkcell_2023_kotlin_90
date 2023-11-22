package com.works.homework_7

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
                Jsoup.connect(url).ignoreContentType(true).timeout(12000).get().toString()

            val doc: Document = Jsoup.parse(weatherStrData, Parser.htmlParser())
            val elementS: Elements = doc.getElementsByTag("Şehirler")

            elementS.forEach { item ->
                val city = item.getElementsByTag("il").text()
                val maxTemp = item.getElementsByTag("Max").text()
                val minTemp = item.getElementsByTag("Min").text()
                val status = item.getElementsByTag("Durum").text()

                val weather = Weather(city, maxTemp, minTemp, status)
                arr.add(weather)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return arr
    }
}
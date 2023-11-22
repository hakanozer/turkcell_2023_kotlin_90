package com.works.weatherforecast.service

import android.util.Log
import com.works.weatherforecast.models.WeatherForecast
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class XmlResult {
    open fun xml(): List<WeatherForecast> {
        val arr = mutableListOf<WeatherForecast>()
        try {
            val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            val stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString()
            val doc: Document = Jsoup.parse(stData, Parser.xmlParser())
            val elements: Elements = doc.getElementsByTag("sehirler")
            for(item in elements) {
                val bolge = item.getElementsByTag("Bolge").text()
                val il = item.getElementsByTag("ili").text()
                val durum = item.getElementsByTag("Durum").text()
                val maxSicaklik = item.getElementsByTag("Mak").text()
                //Şu an sitede xml'de <Min> değerleri boş
                val minSicaklik = item.getElementsByTag("Min").text()
                val w = WeatherForecast(bolge,il, durum, maxSicaklik, minSicaklik)
                arr.add(w)
            }
            Log.d("Weather", arr.toString())

        }catch(ex: Exception) {
            Log.e("Xml Error", ex.toString())
        }
        return arr
    }
}
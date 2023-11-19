package com.davutkarakus.turkcellgelecegiyazanlarodev7

import android.util.Log
import com.davutkarakus.turkcellgelecegiyazanlarodev7.model.Weather
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class WeatherResult {

    fun xml() : List<Weather>{

        val arr = mutableListOf<Weather>()
        try {
            val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            val stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString()
            val doc: Document = Jsoup.parse(stData, Parser.xmlParser())
            val elements: Elements = doc.getElementsByTag("sehirler")
            for (item in elements) {
                val countryName = item.getElementsByTag("ili").text()
                val weatherDescription = item.getElementsByTag("Durum").text()
                val maxTemp = item.getElementsByTag("Mak").text()
                val minTemp = item.getElementsByTag("Min").text()
                val c = Weather(countryName,weatherDescription,maxTemp,minTemp)
                arr.add(c)
            }
        }catch (e:Exception) {
            Log.e("Xml Error",e.toString())
        }
        return arr
    }

}
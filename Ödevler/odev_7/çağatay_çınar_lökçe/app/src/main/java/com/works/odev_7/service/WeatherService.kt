package com.works.odev_7.service

import com.works.odev_7.model.Weather
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class WeatherService {

    fun xml(): List<Weather>{
        val arr = mutableListOf<Weather>()
        val thread = Thread{
            try {
                val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
                val stData = Jsoup.connect(url).ignoreContentType(true).timeout(5000).get().toString()
                val doc: Document = Jsoup.parse(stData,Parser.xmlParser())
                val elements:Elements = doc.getElementsByTag("sehirler")
                for (item in elements){
                    val bolge = item.getElementsByTag("Bolge").text()
                    val peryot = item.getElementsByTag("Peryot").text()
                    val il = item.getElementsByTag("ili").text()
                    val durum = item.getElementsByTag("Durum").text()
                    val maxSicaklik = item.getElementsByTag("Mak").text()
                    val minSicaklik = item.getElementsByTag("Min").text()

                    val w = Weather(bolge, peryot, il, durum, minSicaklik, maxSicaklik)
                    arr.add(w)
                }
            }catch (ex:Exception){
                println(ex.toString())
            }
        }

        thread.start()
        thread.join()
        return arr
    }
}
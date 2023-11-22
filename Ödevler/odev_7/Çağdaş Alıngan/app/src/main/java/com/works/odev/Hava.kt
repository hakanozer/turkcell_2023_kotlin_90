package com.works.odev

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements


class Hava {
    fun veri(): List<HavaDurumu>{
        val arr = mutableListOf<HavaDurumu>()

        try {
            val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            val stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString()
            val doc:Document =Jsoup.parse(stData, Parser.xmlParser())
            val elements: Elements =doc.getElementsByTag("sehirler")
            for (item in elements){


                    val bolge = item.getElementsByTag("Bolge").text()
                    val peryot = item.getElementsByTag("Peryot").text()
                    val il = item.getElementsByTag("ili").text()
                    val durum = item.getElementsByTag("Durum").text()
                    val maxTemp = item.getElementsByTag("mak").text().toString()
                    val minTemp = item.getElementsByTag("min").text().toString()
                    val a = HavaDurumu(bolge,
                                       peryot,
                                       il,
                                       durum,
                                       maxTemp,
                                       minTemp)

                    arr.add(a)

            }


        }catch (ex:Exception){
            Log.e("URL",ex.toString() )
        }
        return arr
    }
}
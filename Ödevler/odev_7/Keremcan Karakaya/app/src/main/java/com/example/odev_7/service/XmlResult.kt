package com.example.odev_7.service

import android.util.Log
import com.example.odev_7.models.Meteoroloji
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class XmlResult {
    fun xml(): List<Meteoroloji> {
        val arr = mutableListOf<Meteoroloji>()
        try{
            val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            val stData = Jsoup.connect(url).ignoreContentType(true).timeout(30000).get().toString();
            val doc: Document = Jsoup.parse(stData, Parser.xmlParser())
            val elements: Elements = doc.getElementsByTag("sehirler")
            for (item in elements){
                val bolge = item.getElementsByTag("Bolge").text()
                val il = item.getElementsByTag("ili").text()
                val durum = item.getElementsByTag("Durum").text()
                val minSicaklik = item.getElementsByTag("Min").text()
                val maxSicaklik = item.getElementsByTag("Mak").text()
                val c = Meteoroloji(bolge, il, durum, minSicaklik, maxSicaklik)
                arr.add(c)
            }
        }catch (ex:Exception){
            Log.e("Xml Error", ex.toString() )
        }
        return arr
    }
}
package com.works.odev_7_.meteroloji

import android.util.Log
import com.works.odev_7_.model.sehirler
import org.jsoup.Jsoup
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class XmlResult {

    fun xml () : List<sehirler> {
        val arr = mutableListOf<sehirler>()
        try {
            val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            val havaData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString()
            val doc : org.jsoup.nodes.Document = Jsoup.parse(havaData , Parser.xmlParser())
            val elements : Elements = doc.getElementsByTag("sehirler")
            for (item in elements){
                val bolge = item.getElementsByTag("bolge").text()
                val il = item.getElementsByTag("ili").text()
                val durum = item.getElementsByTag("Durum").text()
                val maks = item.getElementsByTag("Mak").text()
                val min = item.getElementsByTag("Min").text()
                val sonuc = sehirler(bolge , il , durum , maks , min)
                arr.add(sonuc)
            }
        }catch (ex : Exception){
            Log.e("Xml Error", ex.toString() )
        }
        return arr
    }




}
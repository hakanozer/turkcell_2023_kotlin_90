package com.nazlican.turkcellgelecegiyazanlarhomework7.service

import android.util.Log
import com.nazlican.turkcellgelecegiyazanlarhomework7.model.WeatherModel
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements
import java.lang.Exception

class XmlResult {

    fun xml(): List<WeatherModel> {
        val arrayList = mutableListOf<WeatherModel>()
        try {
            val base_url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            val stData =
                Jsoup.connect(base_url).ignoreContentType(true).timeout(15000).get().toString();
            val doc: Document = Jsoup.parse(stData, Parser.xmlParser())
            val elements: Elements = doc.getElementsByTag("sehirler")
            for (item in elements) {
                val region = item.getElementsByTag("Bolge").text()
                val city = item.getElementsByTag("ili").text()
                val max = item.getElementsByTag("Mak").text()
                val min = item.getElementsByTag("Min").text()
                val c = WeatherModel(region, city, max, min)
                arrayList.add(c)
            }

        } catch (e: Exception) {
            Log.e("xml error", e.toString())
        }
        return arrayList
    }
}
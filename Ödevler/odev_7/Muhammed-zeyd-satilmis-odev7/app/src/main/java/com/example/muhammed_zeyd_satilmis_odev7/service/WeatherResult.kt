package com.example.muhammed_zeyd_satilmis_odev7.service

import android.util.Log
import com.example.muhammed_zeyd_satilmis_odev7.models.WeatherModel
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class WeatherResult {

    fun getResult(): List<WeatherModel> {
        val list = mutableListOf<WeatherModel>()
        val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"

        try {
            val strData =
                Jsoup.connect(url).ignoreContentType(true).timeout(9999).get().toString()
            val doc: Document = Jsoup.parse(strData, Parser.xmlParser())
            val elements: Elements = doc.getElementsByTag("sehirler")

            for (element in elements) {
                val cityName = element.getElementsByTag("ili").text()
                val dayPeriod = element.getElementsByTag("Peryot").text()
                val info = element.getElementsByTag("Durum").text()
                val region = element.getElementsByTag("Bolge").text()
                val maxTemp = element.getElementsByTag("Mak").text().toString()
                val minTemp = element.getElementsByTag("Min").text().toString()
                //oluşturulan her veriyi listeye ekleme işlemi
                val w = WeatherModel(
                    cityName,
                    dayPeriod,
                    info,
                    region,
                    maxTemp,
                    minTemp
                )
                list.add(w)
            }

        } catch (ex: Exception) {
            Log.e("Result Error:", "$ex")
        }
        return list
    }
}

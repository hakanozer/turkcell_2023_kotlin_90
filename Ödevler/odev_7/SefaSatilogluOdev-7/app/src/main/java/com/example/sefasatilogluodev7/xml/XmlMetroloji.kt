package com.example.sefasatilogluodev7.xml

import android.util.Log
import com.example.sefasatilogluodev7.models.Metroloji
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class XmlMetroloji {
    fun verileriAl():List<Metroloji> {
        val arr = mutableListOf<Metroloji>()

        try {

            val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            //Web sitesine baglandik
            val stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString()
            //Baglanti saglandiktan sonra, Document nesnesine aktardik.
            val doc:Document = Jsoup.parse(stData, Parser.xmlParser())
            //Simdi sayfadaki tag ile bilgilere ulasiyoruz.
            //Elements nesnesine aktariyoruz. Sayfadaki her nesne bir Element'tir.
            val elements:Elements = doc.getElementsByTag("sehirler")
            for (item in elements) {

                val bolge = item.getElementsByTag("Bolge").text()
                val il = item.getElementsByTag("ili").text()
                val durum = item.getElementsByTag("Durum").text()
                val minSicaklik = item.getElementsByTag("Min").text()
                val maxSicaklik = item.getElementsByTag("Mak").text()
                for (i in item.text()) {
                    Log.d("bolge",bolge)
                    Log.d("il",il)
                    Log.d("durum",durum)
                    Log.d("minumum sicaklik",minSicaklik)
                    Log.d("maximum sicaklik",maxSicaklik)

                }


                val m = Metroloji(bolge,il,durum,minSicaklik,maxSicaklik)
                arr.add(m)

            }

        }catch (e:Exception) {
            Log.e("Xml Error",e.toString())
        }

        return arr
    }




}
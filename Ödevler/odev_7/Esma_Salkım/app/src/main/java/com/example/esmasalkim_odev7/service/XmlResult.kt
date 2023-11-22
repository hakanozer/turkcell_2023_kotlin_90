package com.example.esmasalkim_odev7.service

import android.util.Log
import com.example.esmasalkim_odev7.models.sehirler
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.parser.Parser
import org.jsoup.select.Elements
import java.lang.Exception

class XmlResult {

    fun xml () : List<sehirler> {

        val arr = mutableListOf<sehirler>()

        try {

            val url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            // jsoup ile bağlantıya eriştik.
            val stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString()
            Log.d("xml", stData)

            // document nesnesine ihtiyacımız var. Aksi takdirde xml içindeki String ifadeler arasında gezinemeyiz
            val doc :Document = Jsoup.parse(stData, Parser.xmlParser())
            // xml dosyasında tekrarlanan değeri Elements ile tanımlıyoruz.
            val elements:Elements = doc.getElementsByTag("sehirler")

            for (item in elements){
                // Log.d("item", item.toString())

                // içindeki elemanlara ulaşma
                val il = item.getElementsByTag("ili").text()
                val durum = item.getElementsByTag("Durum").text()
                val maks = item.getElementsByTag("Mak").text()
                val min = item.getElementsByTag("Min").text()

                val c = sehirler (il, durum, maks, min)

                arr.add(c)

            }


        }catch (ex:Exception){
            Log.e("Xml Error", ex.toString())
        }

        return arr
    }


}
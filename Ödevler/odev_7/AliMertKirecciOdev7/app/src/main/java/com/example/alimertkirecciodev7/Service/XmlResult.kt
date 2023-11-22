package com.example.alimertkirecciodev7.Service

import android.util.Log
import com.example.alimertkirecciodev7.Models.Currency
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements
import java.lang.Exception


class XmlResult {
    fun xml() :  List<Currency> {
        val arr = mutableListOf<Currency>()
        try{
val url="https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
            val havadur=Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();



           val doc:Document=Jsoup.parse(havadur, Parser.xmlParser())
            val elements:Elements=doc.getElementsByTag("sehirler")
           // val elements2:Elements=doc.getElementsByTag("Min")
            for (item in elements){
                val sehirler=item.getElementsByTag("ili").text()
                //text currency ile başlayıp biten alan//
                val Bolge=item.getElementsByTag("Bolge").text()
                val Durum=item.getElementsByTag("Durum").text()
                val MaxDerece=item.getElementsByTag("Mak").text()
                val Minderece=item.getElementsByTag("Min").text()
                val Peryot=item.getElementsByTag("Peryot").text()
                val Shr= Currency(sehirler, Bolge, Durum,MaxDerece,Minderece ,Peryot)


            arr.add(Shr)
            }

        }
        catch (ex:Exception){
            Log.e("Xml Error", ex.toString() )
        }
        return  arr
    }

}
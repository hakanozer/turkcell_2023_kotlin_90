package com.works.days_6.service

import android.util.Log
import com.works.days_6.models.Currency
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser
import org.jsoup.select.Elements

class XmlResult {

    fun xml() : List<Currency> {
        val arr = mutableListOf<Currency>()
        try {
            val url = "https://www.tcmb.gov.tr/kurlar/today.xml"
            val stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();
            val doc:Document = Jsoup.parse(stData, Parser.xmlParser())
            val elements: Elements = doc.getElementsByTag("Currency")
            for (item in elements) {
                val currencyName = item.getElementsByTag("CurrencyName").text()
                val forexBuying = item.getElementsByTag("ForexBuying").text()
                val forexSelling = item.getElementsByTag("ForexSelling").text()
                val banknoteBuying = item.getElementsByTag("BanknoteBuying").text()
                val banknoteSelling = item.getElementsByTag("BanknoteSelling").text()
                val c = Currency(currencyName, forexBuying, forexSelling, banknoteBuying, banknoteSelling)
                arr.add(c)
            }
        }catch (ex: Exception) {
            Log.e("Xml Error", ex.toString())
        }
        return arr
    }


}
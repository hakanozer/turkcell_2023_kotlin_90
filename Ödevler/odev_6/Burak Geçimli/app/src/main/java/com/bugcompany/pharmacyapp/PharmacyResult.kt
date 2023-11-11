package com.bugcompany.pharmacyapp

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class PharmacyResult {

    fun gaziAntep(): LinkedHashMap<String, MutableSet<String>> {
        val arr = LinkedHashMap<String, MutableSet<String>>()
        var set = mutableSetOf<String>()
        try {
            val url = "https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"
            val doc: Document = Jsoup.connect(url).timeout(15000).get()
            val tbody = doc.getElementsByTag("tbody")
            val elements: Elements = tbody[0].getElementsByTag("tr")
            for (item in elements) {
                var ilce = item.getElementsByClass("ilce-baslik").text()
                if (ilce != "") {
                    set = mutableSetOf<String>()
                    ilce = ilce.replace("YAZDIR", "").trim()
                    arr[ilce] = set
                } else {
                    val title = item.getElementsByTag("td").text()
                    set.add(title)
                }
            }
        } catch (ex: Exception) {
            Log.e("URL", ex.toString())
        }
        return arr
    }

}
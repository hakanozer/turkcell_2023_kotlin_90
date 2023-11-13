package com.example.odev_5_android

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class EczaneResult {
    private val url = "https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"

    fun gaziAntepEczaneList(): LinkedHashMap<String, MutableSet<String>> {
        val arr = LinkedHashMap<String, MutableSet<String>>()
        var set = mutableSetOf<String>()

        try {
            val doc: Document = Jsoup.connect(url).timeout(15000).get()
            val tbody = doc.getElementsByTag("tbody")
            val elements: Elements = tbody[0].getElementsByTag("tr")

            for (element in elements) {
                var ilce = element.getElementsByClass("ilce-baslik").text()

                if (ilce != "") {
                    set = mutableSetOf<String>()
                    ilce.replace("YAZDIR", "")
                    ilce = ilce.trim()
                    arr.put(ilce, set)
                } else {
                    val title = element.getElementsByTag("td").text()
                    set.add(title)
                }


            }
        } catch (ex: Exception) {
            Log.e("Url", "$ex")
        }

        return arr

    }


}

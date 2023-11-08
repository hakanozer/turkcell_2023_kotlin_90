package com.works.days_4

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class EczaneResult {

    fun gaziAntep() : LinkedHashMap<String, MutableSet<String>> {
        val arr = LinkedHashMap<String, MutableSet<String>>()
        var set = mutableSetOf<String>()
        try {
            val url = "https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"
            val doc:Document = Jsoup.connect(url).timeout(15000).get()
            val tbody = doc.getElementsByTag("tbody")
            val elements: Elements = tbody[0].getElementsByTag("tr")
            for (item in elements) {
                var ilce = item.getElementsByClass("ilce-baslik").text()
                if (ilce != "") {
                    set = mutableSetOf<String>()
                    ilce = ilce.replace("YAZDIR", "")
                    ilce = ilce.trim()
                    arr.put(ilce, set)
                    //Log.d("TAG", ilce)
                }else {
                    val title = item.getElementsByTag("td").text()
                    set.add(title)
                    //Log.d("title", title)
                }
            }

            /*
            arr.forEach { key, value ->
                Log.d("İlçe", key)
                value.forEach {
                    Log.d("Eczane", it)
                }
            }
            */

        }catch (ex: Exception) {
            Log.e("URL", ex.toString())
        }
        return arr
    }


}
package com.ao.nagihanarabacidays4

import android.content.ContentValues
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.lang.Exception


class EczaneServices {
    private val baseUrl =
        "https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"

    suspend fun  getData(): List<EczaneModel> {
        val arr = LinkedHashMap<String, MutableSet<String>>()
        var set = mutableSetOf<String>()
        val eczanelerList = mutableListOf<EczaneModel>()
        try {
            coroutineScope {
                val doc: Document = async {
                    Jsoup.connect(baseUrl).timeout(1500).get()
                }.await()
                val tbody = doc.getElementsByTag("tbody")
                val elements: Elements = tbody[0].getElementsByTag("tr")
                for (element in elements) {
                    var ilce = element.getElementsByClass("ilce-baslik").text()
                    if (ilce.isNotEmpty()) {
                        set = mutableSetOf<String>()
                        ilce = ilce.replace("YAZDIR", "").trim()
                        arr[ilce] = set
                    } else {
                        val title = element.getElementsByTag("td").text()
                        set.add(title)
                    }
                }
                arr.forEach { (key, value) ->
                    eczanelerList.add(EczaneModel(key, value.toList()))
                }
            }
        } catch (ex: Exception) {
            Log.e("Hata", ex.toString())
        }
        return eczanelerList
    }
}
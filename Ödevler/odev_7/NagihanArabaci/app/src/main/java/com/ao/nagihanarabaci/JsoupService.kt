package com.ao.nagihanarabaci

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class JsoupService {

    companion object {
        private const val baseUrl: String = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"

        val citiesList = mutableListOf<CitiesModel>()

        suspend fun getCitiesList() {
            try {
                CoroutineScope(Dispatchers.IO).launch {
                    val doc: Document = async { Jsoup.connect(baseUrl).timeout(1500).get() }.await()
                    val body = doc.getElementsByTag("sehirler")
                    body.forEach {
                        val bolge = it.getElementsByTag("Bolge").text()
                        val peryot = it.getElementsByTag("Peryot").text()
                        val il = it.getElementsByTag("ili").text()
                        val merkez = it.getElementsByTag("Merkez").text()
                        val durum = it.getElementsByTag("Durum").text()
                        val max = it.getElementsByTag("Mak").text().toIntOrNull() ?: 0
                        val min = it.getElementsByTag("Min").text().toIntOrNull() ?: 0
                        val model = CitiesModel(bolge, peryot, il, merkez, durum, max, min)
                        citiesList.add(model)
                    }
                }.join()
            } catch (e: Exception) {
                e.logger()
            }
        }
    }
}

fun Any.logger() {
    Log.e("Logger", this.toString())
}
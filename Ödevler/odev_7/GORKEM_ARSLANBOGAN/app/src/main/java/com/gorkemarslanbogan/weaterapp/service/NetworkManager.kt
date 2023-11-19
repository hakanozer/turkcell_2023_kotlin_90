package com.gorkemarslanbogan.weaterapp.service

import android.util.Log
import com.gorkemarslanbogan.weaterapp.model.DocumentModel
import com.gorkemarslanbogan.weaterapp.model.WeatherModel
import org.jsoup.Jsoup
import org.jsoup.select.Elements

object NetworkManager : INetworkService {
    private const val BASE_URL = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"
    private const val TIME_OUT = 1500

    override fun getWeaterOfCity(): Elements? {
        return try {
            //burada solid tek sorumluluk ilkesine bağlı kalmak için yapıldı.
            // Tek sorumluluk ilkesi: her sınıfın kendine ait görevi vardır bu sınıfın görevi
            // servisten verileri getirmektir.
            val document = Jsoup.connect(BASE_URL).ignoreContentType(true).timeout(TIME_OUT).get()
            document.getElementsByTag("sehirler")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("Test", "Hata : ${e.printStackTrace()}")
            null
        }
    }
}
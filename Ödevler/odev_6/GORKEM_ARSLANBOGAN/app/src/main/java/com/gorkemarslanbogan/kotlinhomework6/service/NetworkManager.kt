package com.gorkemarslanbogan.kotlinhomework6.service

import android.util.Log
import com.gorkemarslanbogan.kotlinhomework6.model.NobetciEczane
import org.jsoup.Jsoup

interface INetworkManager{
    fun getNobetciEczaneler() : List<NobetciEczane>
    fun getNobetciEczaneler2()
}

class NetworkManager : INetworkManager {

     companion object {
         private const val BASE_URL = "https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"
         private const val TIME_OUT_TIMES = 1500
         public var tarih: String? = null
    }

    //Hocam ilk yöntem daha kolay geldiği için onu kullandım adapter'da.
    //2. yöntem ile veriyi ayrıştırıp modele gönderdim ayrıştırabildiğimi göstermek için..
    override fun getNobetciEczaneler(): List<NobetciEczane> {
        val eczaneList = mutableListOf<NobetciEczane>()
        try {
            val document = Jsoup.connect(BASE_URL).timeout(TIME_OUT_TIMES).get()
            tarih = document.getElementsByClass("nopaddingl").select("h4").text()
            val tableBody = document.getElementsByTag("tbody")
            val element = tableBody[0].getElementsByTag("tr")
            for (item in element) {
                val eczane = NobetciEczane(item.text().replace("YAZDIR", ""))
                eczaneList.add(eczane)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            println("Hata oluştu ${e.printStackTrace()}")
        }

        return eczaneList
    }

    override fun getNobetciEczaneler2() {
        try {
            val document = Jsoup.connect(BASE_URL).timeout(TIME_OUT_TIMES).get()
            val table = document.select("tbody")
            val tdList = table.select("td")
            var eczaneBolge : String? = null
            var eczaneAdi : String? = null
            var eczaneAdres : String? = null
            for (td in tdList) {
                if(td.select("ilce-baslik").isNotEmpty()){
                    eczaneBolge = td.text()
                } else {
                    eczaneAdi = td.select("td:eq(0)").text()
                    eczaneAdres = td.select("td:eq(1)").text()
                }
                val sonrakiSatirIndex = tdList.indexOf(td)
                if(tdList.size > sonrakiSatirIndex) {
                    val birSonrakiDeger = tdList[sonrakiSatirIndex]
                    if(birSonrakiDeger.select("ilce-baslik").isEmpty() && eczaneBolge != null){
                        eczaneAdi = td.select("td:eq(0)").text()
                        eczaneAdres = td.select("td:eq(1)").text()
                    }
                }
//                Log.e("Test", "Eczane Bölge: $eczaneBolge " +
//                        "\n Eczane Adı: $eczaneAdi \n" +
//                        "Eczane Adresi: $eczaneAdres")
            }
        }catch (e: Exception) {
            e.printStackTrace()
            println("Hata oluştu ${e.printStackTrace()}")
        }
    }
}

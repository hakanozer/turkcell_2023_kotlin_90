package com.example.alimertkirecciodev6

import org.jsoup.Jsoup

class InternetServisi
{
    /*tbody[0]*///=Bu şekilde dizi elementin heme yanına gelir*/
   // [0]>>Yerine Select de yazabiliriz.
    companion object {
        private const val Url = "https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"
        private const val timeout = 1500
          var tarih: String? = null
    }

/*Önce jsuop un implementini yapıyoruz ardıından
class sınıf açıyoruz verileri çekebileciğmiz.
data ları getirebilen bir sisteme
jsoup bize der ki sen bana arka tarafda url yi ver ben sana geri document vereyim.
seçecegimiz Docvument Jsoup türünde olmalı.
Connect dediğimiz yapı arka tarafda içersine url yi alır.
TimeOut sayfaayı kontrol edip hata vvarsa geri dönüş sağlayan alandır.
Bekleme Türü dür 15000 üğzerine çıktığında program hata verecektir.
try catch ekleriz haytayı tarasın
Tag Import edilen bir Moduldur.*/
      fun Nobetcieczane1(): List<NobetciEczane> {
        val eczaneList = mutableListOf<NobetciEczane>()
        try {//BUrada Herşeyden önce datayı getirebilen bir iş prensibine gitmemiz lazım
            //  Log.d(TAG, doc.toString())//>Bu İfadenin Tamamını Alır ama biz başlıkları alıcaz.
            //  val tbody=doc.getElementsByTag("tbody")//tbody  html seçeneğini
            //  başlık olarak seçtirip elementin içerisne dizii ile yazarız ve başlıkları alamamyı sağlar.
            val document = Jsoup.connect(Url).timeout(timeout).get()
            tarih = document.getElementsByClass("td").text()
            val tableBody = document.getElementsByTag("tbody")
            val element = tableBody[0].getElementsByTag("tr")
            for (item in element) {
                val eczane = NobetciEczane(item.text().replace("Yazılıcak", ""))
                eczaneList.add(eczane)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            println("Hata oluştu ${e.printStackTrace()}")
        }

        return eczaneList
    }

      fun nobetciecz2() {
        try {
            val document = Jsoup.connect(Url).timeout(timeout).get()
            val table = document.select("tbody")
            val tdList = table.select("td")
            var eczaneBolge : String? = null
            var eczaneAdi : String? = null
            var eczaneAdres : String? = null
            for (td in tdList) {
                val sonrakiSatirIndex = tdList.indexOf(td)
                if(tdList.size > sonrakiSatirIndex) {
                    val birSonrakiDeger = tdList[sonrakiSatirIndex]
                    if(birSonrakiDeger.select("ilce-baslik").isEmpty() && eczaneBolge != null){
                        eczaneAdi = td.select("td").text()
                        eczaneAdres = td.select("td").text()
                    }
                }
                if(td.select("ilce-baslik").isNotEmpty()){
                    eczaneBolge = td.text()
                } else {
                    eczaneAdi = td.select("td").text()
                    eczaneAdres = td.select("td").text()
                }

//
            }
        }catch (e: Exception) {
            e.printStackTrace()
            println("HatalıGirdi ${e.printStackTrace()}")
        }
    }

}
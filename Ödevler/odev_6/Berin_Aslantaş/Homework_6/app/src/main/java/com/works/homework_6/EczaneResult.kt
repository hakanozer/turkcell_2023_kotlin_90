package com.works.homework_6

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


class EczaneResult {

    //Eczane bilgilerini tutmak için DistrictData tanımladım. (Ek bilgiler eklenmesi durumunda daha genişletilebilir bir yapı sağladığı için.)
    // Bu sınıf, ilçe adını ve o ilçeye ait eczane bilgilerini içeriyor.
    data class DistrictData(val districtName: String, val pharmacies: MutableSet<String>)

    fun gaziAntep(): List<DistrictData> {
        // var set = mutableSetOf<String>() yapısını öğrendiğim için farklı yollar deneme amacıyla böyle yaptım.
        val districtDataList = mutableListOf<DistrictData>()

        try {
            val url = "https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"
            val doc: Document = Jsoup.connect(url).timeout(12000).get()

            val tbody = doc.getElementsByTag("tbody")
            val elements: Elements = tbody[0].getElementsByTag("tr")

            var currentDistrict = ""
            val eczaneler = mutableSetOf<String>()

            for (item in elements) {
                val districtElement = item.getElementsByClass("ilce-baslik").text()
                if (districtElement.isNotBlank()) {
                    // isNotEmpty() de kullanılabilir ama isNotBlank()'i boşlukları ve diğer boşluk karakterlerini kontrol etmediği için koydum.
                    currentDistrict = districtElement.replace("YAZDIR", "").trim()
                    eczaneler.clear()
                } else {

                    val title = item.getElementsByTag("td").text()
                    eczaneler.add(title)
                }

                if (currentDistrict.isNotBlank() && eczaneler.isNotEmpty()) {
                    districtDataList.add(DistrictData(currentDistrict, HashSet(eczaneler)))

                }
            }
        } catch (ex: Exception) {
            Log.e("URL", ex.toString())
        }

        return districtDataList
    }
}



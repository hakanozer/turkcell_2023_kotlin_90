package com.example.sefasatilogluodev6


import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
class EczaneResult {
    fun gaziAntep():LinkedHashMap<String, MutableSet<String>>  {


        val arr = LinkedHashMap<String,MutableSet<String>>()
        var set = mutableSetOf<String>()
        try {

            val url = "https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"
            val doc:Document = Jsoup.connect(url).timeout(15000).get()
            //Cogul detayi yakalama
            val tBody = doc.getElementsByTag("tbody")
            val elements: Elements = tBody[0].getElementsByTag("tr")
            for (item in elements) {
                var ilce = item.getElementsByClass("ilce-baslik").text()
                if (ilce != "") {
                    set = mutableSetOf<String>()
                    ilce = ilce.replace("YAZDIR","")
                    ilce = ilce.trim()
                    arr.put(ilce,set)
                    //Log.e("TAG",ilce)
                }else {
                    val title = item.getElementsByTag("td").text()
                    set.add(title)
                    //Log.e("Title",title)
                }



            }
        }catch (e:Exception) {
            e.printStackTrace()
        }


        return arr
    }



}
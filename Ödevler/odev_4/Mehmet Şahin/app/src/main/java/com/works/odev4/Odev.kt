package com.works.odev4

import kotlin.random.Random

//1.soru
open class RandomSayi {
    val randomSayilar = mutableListOf<Int>()
    //veya doğrudan liste atama
    val randomSayilar1 = (1..6).map { Random.nextInt(1,50) }
    fun rastgeleSayi () {
        for(i in 1..6) {
            val rastgele = Random.nextInt(1,50)
            randomSayilar.add(rastgele)
        }
        println(randomSayilar)
        println(randomSayilar1)
    }

}

//2.soru
class BuyukSayi {
    var a = "23456789876543234567890987654567890".toBigInteger()
    var b = "99999999999988888888882222222688981".toBigInteger()
    init {
        println(a+b)
    }
}

//4.soru

class KotlinList(): RandomSayi() {
    init {
        randomSayilar1.forEach{
            println(it)
        }
    }
}

//5.Soru

open class SetList() {
    val set = mutableSetOf(1,2,3,4,5,5,5,6,7,7,8,9,9,10)
    val list = mutableListOf(1,2,5,2,3,4,5,6,7,8,8,9,9,10)
    //list sırası korunacak
    val setList = list.union(set)
    init {
        println("Korunmuş liste : $setList")
    }
}

//6.Soru

class SayiTekrar ():SetList()  {
    fun tekrarKontrol(kontrolSayi : Int) {
        var sayac = 0
        for(item in list) {
            if(item == kontrolSayi) sayac++
        }
        println("$kontrolSayi sayısının tekrar adeti : $sayac")
    }
}


//7.soru
class YasAraligi (val yas: List<Int>) {
    //val yas = listOf(18,24,30,36,25,34,40,32,35,32,44,50,52,54)
    fun yasAraligi() {
        val yasAraligi = yas.groupBy {
            when {
                it in 18..24 -> "18-24 yaş aralığında"
                it in 25..31 -> "25-31 yaş aralığında"
                it in 32..38 -> "32-38 yaş aralığında"
                it in 39..45 -> "29-45 yaş aralığında"
                else -> "46 yaş üstünde"
            }
        }
        println(yasAraligi)
        for((yasAralik, yaslar) in yasAraligi) {
            println("$yasAralik - $yaslar")
        }
    }


}





//8.Soru

class ListToplam() {
    var toplam = 0
    val list = mutableListOf<Int>(-10,-8,10,15,28,-29,14,13,24)
    init {
        list.forEach {
            if(it > 0) {
                toplam += it
            }
        }
        println("Pozitif sayıların toplamı : $toplam")
    }
}


//9.Soru

class ListFiltre(var liste: List<Any?>) {
    fun filtreList() {
        val yeniList = mutableListOf<Any>()
        for( i in liste) {
            if(i != null) yeniList.add(i)
        }
        println(yeniList)
    }
}

//10.soru
class KelimeMaxMin() {
    val list = mutableListOf("merhaba", "Dünya", "Ali", "Mehmet", "Lorem", "Kullanmak").sortedBy{it.length}
    init {
        val uzunKelime = list.last()
        val kisaKelime = list.first()
        println("""
            Listeniz : $list
            Listeniz içerisinde en kisa kelime : $kisaKelime
            Listeniz içerisinde en uzun kelime : $uzunKelime
        """.trimIndent())
    }
}


//11.soru

class ListSort() : RandomSayi() {
    val a = randomSayilar1.sortedDescending()
    init {
        println("Sıralanmış liste: $a")
    }
}

//12.Soru
class OrtakEleman() {
    fun Set() {
        val set1 = mutableSetOf(1,2,3,4,5,6,7,8, "Ali", "Mehmet",null)
        val set2 = mutableSetOf(5,6,7,8,9,10,11,12,"Mehmet",null)
        val set3 = mutableSetOf<Any?>()
        //veya kesişim
        val set4 = set1.intersect(set2)

        for(i in set1) {
            for(j in set2){
                if(i == j) {
                    set3.add(j)
                }
            }

        }
        println("Null hariç set : $set3")
        println("Null hariç alternatif yol set: $set4")
}


}

package com.works.odev4

import java.math.BigInteger
import java.util.Scanner
import kotlin.random.Random

fun main(args: Array<String>) {

    // Soru 1 :

    val rsayi = mutableListOf<Int>()
    for (i in 1..49) {
        rsayi.add(i)
    }
    for (i in 1..6) {
        val randomsayi = rsayi.random()
        println(randomsayi)

    }


    // Soru 2 :

    val stringA = "1312312312361231263612367123612312"
    val stringB = "8324823423489234983248328973248723"

    val sayia = BigInteger(stringA)
    val sayib = BigInteger(stringB)
    val sum = sayia + sayib
    println("Toplamları : $sum")


    // Soru 3 :

    val girdi = Scanner(System.`in`)
    val kisilistesi = ArrayList<kisi>()

    println(
        "1 - Tüm Kayıtları Göster\n" +
                "    2 - Yeni Kayıt Ekle\n" +
                "    3 - Kayıt Sil\n" +
                "    4 - Kayıt Güncelle\n" +
                "    5 - Tümünü Temizle\n" +
                "    6 - Kayıt Ara (Ad veya Soyada Göre)\n" +
                "    7 - Kayıt Ara (Telefon Numarasına Göre)\n" +
                "    8 - Çıkış"
    )
    println("Lütfen seçiminizi yapınız : ")
    val menu = girdi.nextInt()

    if (menu == 1) {
        println("Tüm kayıtlar gösteriliyor : ")
        if (kisilistesi.isEmpty()) {
            println("Henüz kayıtlı kişi bulunmamaktadır.")
        } else {
            println("$kisilistesi")
        }

    } else if (menu == 2) {
        println("Adınızı giriniz : ")
        val ad = girdi.next()
        println("Soyadınızı giriniz : ")
        val soyad = girdi.next()
        println("Telefon numaranızı giriniz : ")
        val telnumara = girdi.next()
        kisilistesi.add(kisi(ad, soyad, telnumara))
        println("Kaydınız oluşmuştur.")
    } else if (menu == 3) {
        println("Silmek istediğiniz kişinin numarasını giriniz : ")
        val silme = girdi.nextInt()
        kisilistesi.removeAt(silme)
        println("Silme işlemi başarılı sonuçlanmıştır.")
    } else if (menu == 4) {
        println("Güncellemek istediğiniz sıra numarasını giriniz : ")
        val update = girdi.nextInt()
        if (update in 0 until kisilistesi.size) {
            println("Yeni isminizi giriniz : ")
            val ad = girdi.next()
            println("Yeni soyadınızı giriniz : ")
            val soyad = girdi.next()
            println("Yeni telefon numaranızı giriniz : ")
            val telnumara = girdi.next()
            kisilistesi.add(kisi(ad, soyad, telnumara))
            println("Güncellemeniz tamamlanmıştır.")
        }
    } else if (menu == 5) {
        kisilistesi.clear()
        println("Tüm kayıtlar temizlenmiştir.")
    } else if (menu == 6) {
        println("Aramak istediğiniz kaydı giriniz : ")
        val aranan = girdi.next()
        val arama = kisilistesi.filter {
            it.name.contains(aranan, ignoreCase = true) || it.surname.contains(
                aranan,
                ignoreCase = true
            )
        }
        println("$arama")
    } else if (menu == 7) {
        println("Aramak istediğiniz telefon numarasını giriniz : ")
        val aranantelno = girdi.next()
        val aramatelno =
            kisilistesi.filter { it.phonenumber.contains(aranantelno, ignoreCase = true) }
        println("$aramatelno")
    } else if (menu == 8) {
        println("Çıkış yapılıyor.")
    } else {
        println("Yanlış seçim yaptınız.")
    }

    // Soru 4 :

    val list = listOf<String>("Ne", "Güzelsin", "Sen", "Cumhuriyet", "♥", "Mustafa Kemal Atatürk")
    val asillist = list
    for (i in asillist) {
        println(i)
    }

    // Soru 5 :

    class soru5 {
        fun liste() {
            val setliste = mutableSetOf<Int>(2, 9, 1, 0, 1, 9)
            val liste5 = listOf<Int>(2, 3, 2, 3, 5)
            setliste.addAll(liste5)
            println(setliste)
        }
    }

    val sonuc = soru5()
    println(sonuc.liste())

    // Soru 6 :

    val listtekrar = listOf<String>("Oğuz", "Baran", "Oğuz", "Apple", "Fenerbahçe", "Fenerbahçe")
    val tekrarlanan =
        listtekrar.filter { elemanlariSayma -> listtekrar.count() { it == elemanlariSayma } > 1 }
    println(tekrarlanan)


    // Soru 7 :

    // Soru 8 :

    var sum8 = 0
    val listsum = listOf<Int>(1, 2, 3, 4, -1, -8, 3, 4, 5, 10, -7, -19, -17, 30)
    for (item in listsum){
        if (item >= 0){
            sum8+=item
        }
    }
    println("Pozitif sayıların toplamı : $sum8")

    // Soru 9 :

    val list9 = listOf("Oğuz" , "Baran" , "Elif" , null , null)
    val newlist = mutableListOf<String>()

    for (i in list9){
        if (i != null){
            newlist.add(i)
        }
    }
    println("Yeni listeniz : " + newlist)

    // Soru 10 :

    val list10 = arrayListOf("Oğuz" , "Şahingil" , "Baran")
    val sıralama = list10.sortedByDescending { it.length }

    val enkisametin = sıralama.last()
    val enuzunmetin = sıralama.first()
    val enkisametinsayi = sıralama.last().length
    val enuzunmetinsayi = sıralama.first().length

    println("Listedeki;\n En kısa metin : $enkisametin ($enkisametinsayi)\n En uzun metin : $enuzunmetin ($enuzunmetinsayi)")

    // Soru 11 :

    val list11 = arrayListOf<Int>()
    for (i in 1..20){
        list11.add(Random.nextInt(i))
    }
    println(list11)

    val buyuktenkucugesayilar = list11.sortDescending()
    println(buyuktenkucugesayilar)

    // Soru 12 :

    val list12 = setOf("Yaşasın" , "Cumhuriyet" , "Fenerbahçe" , "Atatürk")
    val list_12 = setOf("Oğuz" , "Elif" , "Yaşasın" , "Türkiye" , "Cumhuriyet")

    //İntersect ile yapımı.
    //val ortakelemanlar = list12.intersect(list_12)
    //println("Listedeki ortak elemanlar:\n  $ortakelemanlar")

    val ortakelemanlar = mutableListOf<String>()

    for (i in list12){
        for (b in list_12){
            if (i==b){
                ortakelemanlar.add(i)
            }
        }
    }
    println("Listedeki ortak elemanlar:\n  $ortakelemanlar")


}
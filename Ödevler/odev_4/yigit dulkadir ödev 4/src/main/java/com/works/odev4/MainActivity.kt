package com.works.odev4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlin.random.Random
//soru 1/////////////////////////////////
fun rastgeleSayiSec(): List<Int> {
    val sayilar = (1..49).shuffled()
    return sayilar.take(6).sorted()
}

///////soru 2/////////////////////////////////


//  hocam 2' yi çözemedim.  internetteki çözümü de anlamadım :( Çözüm olarak  alttaki yazıyo idi./////////////

fun stringToplama(a: String, b: String): String {
    var sonuc = StringBuilder()
    var carry = 0

    val maxUzunluk = maxOf(a.length, b.length)
    val aPadded = a.padStart(maxUzunluk, '0')
    val bPadded = b.padStart(maxUzunluk, '0')

    for (i in maxUzunluk - 1 downTo 0) {
        val toplam = (aPadded[i] - '0') + (bPadded[i] - '0') + carry
        sonuc.append(toplam % 10)
        carry = toplam / 10
    }

    if (carry > 0) {
        sonuc.append(carry)
    }

    return sonuc.reverse().toString()
}



/////////////////////////////////////////////////////////////////////////////////////////////////


//soru 4 //////////////////////////////////////
fun elemanlariYazdir(liste: List<Any>) {
    for (eleman in liste) {
        println(eleman)
    }
}
//soru 5 //////////////////////////////////////////////////////////////
fun birlestirVeYazdir(set: Set<Any>, liste: List<Any>) {
    val sonuc = mutableListOf<Any>()


    sonuc.addAll(set)


    for (eleman in liste) {
        if (!sonuc.contains(eleman)) {
            sonuc.add(eleman)
        }
    }

    println(sonuc)
}
////////////////////////////////////////////////////////////////////////////////////////

//soru 6 ///////////////////////////////////////////////////////////////////////////////

fun tekrarSayisi(liste: List<Any>, deger: Any): Int {
    return liste.count { it == deger }
}

///////////////////////////////////////////////////////////////////////////////////

//soru7////////////////////////////////////////////////////////////////////////////

fun yaslariGrupla(yaslar: List<Int>): Map<String, List<Int>> {
    return yaslar.groupBy {
        when(it) {
            in 0..17 -> "0-17"
            in 18..24 -> "18-24"
            in 25..34 -> "25-34"
            in 35..44 -> "35-44"
            in 45..54 -> "45-54"
            in 55..64 -> "55-64"
            else -> "65+"
        }
    }
}
//////////////////////////////////////////////////////////////////////////////////////////

//soru8///////////////////////////////////////////////////////////////////////////////////

fun pozitifToplam(liste: List<Int>): Int {
    return liste.filter { it > 0 }.sum()
}

////////////////////////////////////////////////////////////////////////////

//soru9/////////////////////////////////////////////////////////////////////


///  Hocam  soru 9 da  stackoverflow daki  çözümü kullandım  benim yaptıklarım çalışmıyor idi :(////////
fun nullOlmayanlariFiltrele(liste: List<Any?>): List<Any> {
    return liste.filterNotNull()
}
/////////////////////////////////////////////////////////////////////////////////////////////////////

//soru 10 //////////////////////////////////////////////////////////////////////////////////////////

fun enKisaVeEnUzunMetniBul(liste: List<String>): Pair<String, String> {
    val enKisa = liste.minByOrNull { it.length } ?: ""
    val enUzun = liste.maxByOrNull { it.length } ?: ""
    return Pair(enKisa, enUzun)
}
////////////////////////////////////////////////////////////////////////////////////////////////

//soru11////////////////////////////////////////////////////////////////////////////////////////

fun buyuktenKucugeSiralama(liste: List<Int>): List<Int> {
    return liste.sortedDescending()
}
///////////////////////////////////////////////////////////////////////////////////////////

///soru12////////////////////////////////////////////////////////////////////////////////

fun ortakElemanlariBul(set1: Set<Any>, set2: Set<Any>): Set<Any> {
    return set1.intersect(set2)
}

/////////////////////////////////////////////////////////////////////////////////////////////


//soru 3 ////////////////////////////////////////

//  Hocam ben çözemedim  internetten benzerini bulup  üstünde birkaç oynama yaptım ////////////

data class Kisi(var ad: String, var soyad: String, var tel: String)


fun main() {
    val ornekListe = listOf("elma", "armut", "muz", "kiraz", "üzüm")
    elemanlariYazdir(ornekListe)


    val secilenSayilar = rastgeleSayiSec()
    println("Seçilen sayılar: $secilenSayilar")

//////////////////////////////////////////////////////////

    val a = "23456789876543234567890987654567890"
    val b = "99999999999988888888882222222688981"
    val cevap = stringToplama(a, b)
    println("Cevap: $cevap")



///////////////////////////////////////////////////////////////////////
    val deger1 = setOf("1", "2", "3")
    val deger2 = listOf("muz", "elma", "üzüm", "kiraz", "armut")

    birlestirVeYazdir(deger1, deger2)

////////////////////////////////////////////////////////////////////////////

    val arabalar = listOf("Toyota", "Mercedes", "BMW", "Toyota", "Hyundai", "Mercedes", "Ferrari", "Toyota")
    val arananMarka = "Toyota"

    val sonuc = tekrarSayisi(arabalar, arananMarka)
    println("$arananMarka markası arabalar listemizde $sonuc kez tekrarlanıyor.")

////////////////////////////////////////////////////////////////////////////////////////////

    val yasListesi = listOf(15, 23, 34, 18, 65, 40, 29, 54, 21, 33, 60, 70)
    val gruplanmisYaslar = yaslariGrupla(yasListesi)

    for ((grup, yasListesi) in gruplanmisYaslar) {
        println("$grup: $yasListesi")
    }

/////////////////////////////////////////////////////////////////////////////////////////////////

    val sayilar = listOf(15, -23, 34, -18, 65, -40, 29)
    val toplam = pozitifToplam(sayilar)

    println("Pozitif sayıların toplamı: $toplam")

//////////////////////////////////////////////////////////////////////////////////////////////////////

    val karmaListe = listOf("Merhaba", null, 42, "Dünya", null, 24)
    val filtrelenmisListe = nullOlmayanlariFiltrele(karmaListe)

    println(filtrelenmisListe)

///////////////////////////////////////////////////////////////////////////////////////////////////////



    val metinListesi = listOf("Merhaba", "Kotlin", "Dünya", "Programlama")
    val (enKisa, enUzun) = enKisaVeEnUzunMetniBul(metinListesi)

    println("En kısa metin: $enKisa")
    println("En uzun metin: $enUzun")
/////////////////////////////////////////////////////////////////////////////////////////////////////////

    val sayiListesi = listOf(34, 15, 9, 42, 56, 21)
    val siralanmisListe = buyuktenKucugeSiralama(sayiListesi)

    println(siralanmisListe)

////////////////////////////////////////////////////////////////////////////////////////////////////////////

    val set1 = setOf("sait", "faik", "abasıyanık", "kitap")
    val set2 = setOf("muz", "faik", "elma", "abasıyanık")

    val ortakElemanlar = ortakElemanlariBul(set1, set2)

    println("Ortak elemanlar: $ortakElemanlar")

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    val rehber = mutableListOf<Kisi>()

        while (true) {
            println("""
            Menü:
            1 - Tüm Kayıtları Göster
            2 - Yeni Kayıt Ekle
            3 - Kayıt Sil
            4 - Kayıt Güncelle
            5 - Tümünü Temizle
            6 - Kayıt Ara (Ad veya Soyada Göre)
            7 - Kayıt Ara (Telefon Numarasına Göre)
            8 - Çıkış
            """.trimIndent())

            when (readLine()?.toIntOrNull()) {
                1 -> rehber.forEach { println(it) }
                2 -> {
                    print("Ad: ")
                    val ad = readLine().orEmpty()
                    print("Soyad: ")
                    val soyad = readLine().orEmpty()
                    print("Tel: ")
                    val tel = readLine().orEmpty()
                    rehber.add(Kisi(ad, soyad, tel))
                    println("Kayıt eklendi.")
                }
                3 -> {
                    print("Silmek istediğiniz kişinin telefon numarası: ")
                    val tel = readLine().orEmpty()
                    rehber.removeAll { it.tel == tel }
                    println("Kayıt silindi.")
                }
                4 -> {
                    print("Güncellemek istediğiniz kişinin telefon numarası: ")
                    val tel = readLine().orEmpty()
                    val kisi = rehber.find { it.tel == tel }
                    if (kisi != null) {
                        print("Yeni Ad: ")
                        kisi.ad = readLine().orEmpty()
                        print("Yeni Soyad: ")
                        kisi.soyad = readLine().orEmpty()
                        println("Kayıt güncellendi.")
                    } else {
                        println("Kişi bulunamadı.")
                    }
                }
                5 -> {
                    rehber.clear()
                    println("Tüm kayıtlar temizlendi.")
                }
                6 -> {
                    print("Aranacak Ad veya Soyad: ")
                    val arama = readLine().orEmpty().toLowerCase()
                    val sonuclar = rehber.filter { it.ad.toLowerCase().contains(arama) || it.soyad.toLowerCase().contains(arama) }
                    sonuclar.forEach { println(it) }
                }
                7 -> {
                    print("Aranacak Telefon Numarası: ")
                    val tel = readLine().orEmpty()
                    val kisi = rehber.find { it.tel == tel }
                    if (kisi != null) {
                        println(kisi)
                    } else {
                        println("Kişi bulunamadı.")
                    }
                }
                8 -> {
                    println("Çıkış yapılıyor...")
                    return
                }
                else -> {
                    println("Hatalı seçim!")
                }
            }
        }


}
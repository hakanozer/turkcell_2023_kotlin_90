package com.example.esmasalkim_odev4

import java.lang.Exception
import java.math.BigInteger
import java.util.Scanner
import kotlin.random.Random

fun main(args: Array<String>) {
    println(soru1())
    println(soru2())
    println(soru3())
    println(soru4())
    println(soru5())
    println(soru6())
    println(soru7())
    println(soru8())
    println(soru9())
    println(soru10())
    println(soru11())
    println(soru12())
}

fun soru1(){

    val secilenSayilar = mutableSetOf<Int>() // benzersiz seçmesi için mutableSetOf kullandım.
    println("Seçilen 6 sayı : ")

    while (secilenSayilar.size < 6){
        val rastgeleSayilar = Random.nextInt(1, 49)
        secilenSayilar.add(rastgeleSayilar)
    }
    for (sayilar in secilenSayilar){
        println(sayilar)
    }
}

fun soru2(){
    val str1 = BigInteger ("23456789876543234567890987654567890")
    val str2 = BigInteger ("99999999999988888888882222222688981")

    try {
        val toplam = str1 + str2
        println("Toplam : $toplam")
    }catch (ex:Exception){
        println("Hata oluştu : " + ex.message)
    }
}

fun soru3(){

    val scn = Scanner(System.`in`)

    data class Kisi (var ad : String , var soyad : String, var telNo : String)
        val kisiler = mutableListOf<Kisi>()

    while (true) {
        println(
            """ MENÜ
                1 - Tüm Kayıtları Göster
                2 - Yeni Kayıt Ekle
                3 - Kayıt Sil
                4 - Kayıt Güncelle
                5 - Tümünü Temizle
                6 - Kayıt Ara (Ad veya Soyada Göre)
                7 - Kayıt Ara (Telefon Numarasına Göre)
                8 - Çıkış
            """.trimIndent()
        )
        println("Lütfen Seçim Yapınız:")

        val secim = scn.nextInt()

        if (secim != null && secim in 1..8) {


            if (secim == 1) {
                kisiler.forEachIndexed { index, kisi ->
                    println("$index - ${kisi.ad} ${kisi.soyad}, Tel: ${kisi.telNo}")
                }

            } else if (secim == 2) {
                print("Ad : ")
                val ad = scn.next()
                print("Soyad : ")
                val soyad = scn.next()
                print("Telefon Numarası : ")
                val tel = scn.next()

                val yeniKisi = Kisi(ad, soyad, tel)
                kisiler.add(yeniKisi)
                println(" Yeni kişi başarıyla eklendi! ")

            } else if (secim == 3) {
                println("Silmek istediğiniz kişinin sıra numarasını girin")
                val silinecekKisi = readLine()?.toIntOrNull()
                if (silinecekKisi != null && silinecekKisi in 0..kisiler.size - 1) {
                    kisiler.removeAt(silinecekKisi)
                    println("Kişi silindi!")
                } else {
                    println("Lütfen geçerli bir değer giriniz !")
                }

            } else if (secim == 4) {
                println("Güncellemek istediğiniz kişinin sıra numarasını giriniz")
                val güncellenecekKisiNo = readLine()?.toIntOrNull()
                if (güncellenecekKisiNo != null && güncellenecekKisiNo in 0..kisiler.size - 1) {
                    print("Yeni Ad :")
                    val yeniAd = scn.next()
                    print("Yeni Soyad :")
                    val yeniSoyad = scn.next()
                    print("Yeni Telefon Numarası :")
                    val tel = scn.next()
                    kisiler[güncellenecekKisiNo] = Kisi(yeniAd, yeniSoyad, tel)
                    println("Kişi başarıyla güncellendi")
                } else {
                    println("Geçerli sıra numarası giriniz!")
                }

            } else if (secim == 5) {
                kisiler.clear()
                println("Tüm kişiler silindi!")

            } else if (secim == 6) {
                print("Aranacak kişinin Ad ve Soyadı: ")
                val arananKisi = readLine() ?: ""
                val arama = kisiler.filter {
                    it.ad.contains(arananKisi, ignoreCase = true) || it.soyad.contains(arananKisi, ignoreCase = true)
                }
                if (arama.isEmpty()) {
                    println("Sonuç bulunamadı !")
                } else {
                    arama.forEachIndexed { index, kisi ->
                        println("Aranan kişi : $index - ${kisi.ad} ${kisi.soyad} ${kisi.telNo}")
                    }
                }

            } else if (secim == 7) {
                print("Aranacak Kişinin Telefon Numarası: ")
                val arananKisiTel = scn.next()
                val arama = kisiler.filter { it.telNo.contains(arananKisiTel) }
                if (arama.isEmpty()) {
                    println("Sonuç bulunamadı !")
                } else {
                    arama.forEachIndexed { index, kisi ->
                        println("Aranan kişi : $index - ${kisi.ad} ${kisi.soyad} ${kisi.telNo}")
                    }
                }

            } else if (secim == 8) {
                println("Çıkış yapılıyor")
                return
            }
        }
        else{
            println("Lütfen 1 - 8 arasında bir seçim yapın")
        }
    }



}

fun soru4(){

    val kotlinList =   listOf("Elazığ", "Şanlıurfa", "Malatya", "İstanbul", "Ankara")

    for(sehirler in kotlinList){
        println(sehirler)
    }
}

fun soru5(){
    //Depremden etkilenen illerin birleşimini getiren programı yazdım.
    val setDepremList = setOf<String>("Elazığ","Malatya","ŞanlıUrfa","KahramanMaraş","Adıyaman")
    val depremList = listOf<String>("Elazığ","Malatya","Adana","Diyarbakır","Hatay","Gaziantep","Osmaniye","Kilis")


    val ortakKoleksiyon = setDepremList.toMutableSet()
    ortakKoleksiyon.addAll(depremList)

    println("Birleşmiş Olarak Deprem Şehirlerimiz : $ortakKoleksiyon")

}

fun soru6(){

    val randomSayiList = listOf<Int>(1,2,23,44,63,23,44,81,80,23,63,63)
    val belirlemisOldugumSayi = 63
    var count = 0

    for (sayilar in randomSayiList){

        if(sayilar == belirlemisOldugumSayi)
        {
            count = count + 1
        }

    }
    println("Belirlemiş oldunuz sayı randomSayiList içerisinde " + count + " defa geçmektedir.")


}

fun soru7() {

    val girilenYasBilgileri = listOf<Int>(0,3,6,9,21,23,30,32,40,45,55,63,75,90,101)

    val yasKategorileri = girilenYasBilgileri.groupBy { yas->
        when(yas){
            in 0..15->"Çocuk (0-15)"
            in 16..39 ->"Genç(16-39)"
            in 40..55 ->"Orta Yaşlı(40-55)"
            in 56..100->"Yaşlı(56-100)"
            else
               -> "Çok Yaşlı(Ölmeyi unutmuş) :)(100+)"

        }
    }
    for ((yasGrubu, listdeBulananYaslar) in yasKategorileri) {
        println("$yasGrubu yaş aralığındaki yaşlar: $listdeBulananYaslar")
    }


}

fun soru8(){

    val randomSayiList = listOf<Int>(-23,-44,23,44,63,-5,1,2)
    var toplam = 0
    var listdeBulunanSayiAdedi = 0
    var listdeBulunanNegatifSayiAdedi = 0
    for (sayi in randomSayiList)
    {
        listdeBulunanSayiAdedi ++

        if(sayi > 0)
        {
            toplam +=  sayi
        }
        else{
            listdeBulunanNegatifSayiAdedi++
        }
    }
 println("Verilen listede " +listdeBulunanSayiAdedi+ " adet sayıdan , pozitif sayıların toplamı "
         + toplam + " olup " + listdeBulunanNegatifSayiAdedi+ " Sayı negatiftir.")
}

fun soru9(){

    val karmaVeriList = listOf("ŞanlıUrfa",null,"","Elazığ","Malatya",null,23,44)
    val filtrelenmisList = filtrelenmisList(karmaVeriList)
    println("Filtrelenmiş yeni List" +filtrelenmisList )
}
fun <T : Any> filtrelenmisList(karmaVeriList: List<T?>): List<T> {
    return karmaVeriList.filterNotNull()
}

fun soru10() {

    val sehirList = listOf("Elazığ","Şanlıurfa","GaziAntep","Kilis","KahramanMaraş","İzmir")

    val uzunlukSirasi = sehirList.sortedBy { it.length }
    val enKisaSehir = uzunlukSirasi.first()
    val enUzunSehir = uzunlukSirasi.last()

    println("Girilen şehir Listeleri içerisinden en uzun harfli şehir " +enUzunSehir + " en kısa harfli şehir " +enKisaSehir)

}

fun soru11(){

    val randomSayiList = listOf(1,23,44,63,81,27,2,21)
    val siralanmisList = siralaBuyuktenKucuge(randomSayiList)

    println("Girilen listede büyükten küçüğe sayılar " + siralanmisList)
}
fun siralaBuyuktenKucuge(liste: List<Int>): List<Int> {
    return liste.sortedDescending()
}

fun soru12(){

    val ilkSetList = listOf(1,2,3,4,5,6,7)
    val ikinciSetList = listOf(5,6,7,8,9)

    val ortakElemanList = ilkSetList.toMutableSet()
    ortakElemanList.retainAll(ikinciSetList)

    println("Girilen her iki set içerisinde ortak olan elemanlar : "+ortakElemanList)

}





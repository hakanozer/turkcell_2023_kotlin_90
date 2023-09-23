package com.example.works_turkcell._odevler

import java.lang.Exception
import java.util.Scanner

fun main(args: Array<String>) {

    println(" ------------------- Soru_1 ------------------------ ")

    val Scanner = Scanner(System.`in`)
    println("1.Kenar Değeri Giriniz:")
    val ucgndDgr1 = Scanner.nextInt()
    println("2.Kenar Değeri Giriniz:")
    val ucgndDgr2 = Scanner.nextInt()
    println("3.Kenar Değeri Giriniz:")
    val ucgndDgr3 = Scanner.nextInt()

    val ucgnSonuc = ucgenOlusturmaKontrol(ucgndDgr1, ucgndDgr2, ucgndDgr3)
    println("Sonuc: $ucgnSonuc")

    println(" ------------------- Soru_2 ------------------------ ")

    println(" Menü :  ")
    println(" 1 - F -> C")
    println(" 2 - C -> F ")
    println(" Seçim:  ")
    var secilen = Scanner.nextInt()
    var dogruDeger = true

    if ((secilen != 1 && secilen != 2) || secilen == null) {
        while (dogruDeger) {
            println("Hatalı seçim yaptınız. Menüde bulunan seçimlerden birini giriniz :")
            secilen = Scanner.nextInt()
            if (secilen == 1 || secilen == 2) {
                dogruDeger = false
            }
        }
    }
    println(" Değer Giriniz :  ")
    val girDeg = Scanner.nextDouble()
    val secilenDegerler = menuSec(secilen, girDeg)
    println(secilenDegerler)


    println(" ------------------- Soru_3 ------------------------ ")

    println(" 1. Sayıyı Giriniz: ")
    val sayi1 = Scanner.nextInt()
    println(" 2. Sayıyı Giriniz: ")
    val sayi2 = Scanner.nextInt()

    val sayiDurum = sayiDurumu(sayi1, sayi2)
    println(sayiDurum)

    println(" ------------------- Soru_4 ------------------------ ")

    println(" N Toplam İçin Bir Sayı Giriniz: ")
    val nTop = Scanner.nextInt()

    val toplamDeger = sayiToplam(nTop)
    println(" Toplam : $toplamDeger ")

    println(" ------------------- Soru_5 ------------------------ ")

    println(" Lütfen 3 Basamaklı Bir Sayı Giriniz:  ")
    val ucBasamak = Scanner.nextInt()

    val sayiToplam = basamakToplam(ucBasamak)
    println( sayiToplam )

    println(" ------------------- Soru_6 ------------------------ ")

    println(" Lütfen 3 basamaklı bir sayı girin : ")
    val ucBasamakliSayi = Scanner.nextInt()
    val sayininTersi = sayiTersYaz(ucBasamakliSayi)
    println(" $ucBasamakliSayi sayısının tersi : $sayininTersi ")

    println(" ------------------- Soru_7 ------------------------ ")

    println("Kaç adet sayı gireceksiniz?")
    val adetSayi = Scanner.nextInt()
    val dizi = IntArray(adetSayi)
    if (adetSayi < 0) {
        println("Pozitif bir sayı giriniz.")
    }
    for (i in 1..adetSayi) {
        println("$i . sayıyı giriniz")
        val sayiDeger = Scanner.nextInt()
        dizi[i - 1] = sayiDeger
    }

    val sonucMesaji = nSayiRaporu(adetSayi, dizi)

    println(sonucMesaji)


    println(" ---------------------------------------------- ")
}
/**
 * 1 - Kullanıcıdan 3 Kenar Değeri Alıyorsun
 * Bu 3 Değerden Üçgen Yapılıp Yapılamayacağını
 * Test Edip Sonucu Bastıracaksınız
 *
 * Her 2 Kenarın Toplamı Diğer 3. Kenara Eşit/Fazlaysa Üçgen olur
 */

fun ucgenOlusturmaKontrol(num1: Int, num2: Int, num3: Int): String {

    var ucgenKontrolMesaj: String = ""
    if (num1 + num2 >= num3 && num1 + num3 >= num2 && num2 + num3 >= num1) {
        ucgenKontrolMesaj = "Üçgen Oluşturur --> $num1 - $num2 - $num3 Üçgeni "
    } else {
        ucgenKontrolMesaj = "Girilen Değerler Üçgen Oluşturmaz!"
    }

    return ucgenKontrolMesaj
}

/**
 *
 * 2 -
 * 	Kullanıcıya Aşağıdaki Menuyu Gösteriyorsunuz
 *
 * 	Menu :
 * 	1 - F -> C
 * 	2 - C -> F
 * 	    Secim :
 *
 * 	Kullanıcı 1'i Seçerse Fahrenheit Değerini Alıyorsunuz
 * 	Girilen Değeri Dereceye Çevirip
 * 	x F = y C Şeklinde Ekranda Gösteriyorsunuz
 *
 * 	Eğer 2. Seçenek Seçildiyse, C Değerini Alıyorsunuz
 * 	Girilen Değeri Fahrenheit'a Çevirip
 * 	x C = y F Şeklinde Ekranda Gösteriyorsunuz
 *
 * 	Eğer Kullanıcı Menu Seceneginde 1,2 Dışında Bir Sayı
 * 	Girerse Ekrana Hatalı Seçim Mesajını Bastırmalısınız
 */

fun menuSec(secim: Int, deger: Double): String {

    var sonuc: String = ""

    if (secim != null && deger != null) {

        if (secim == 1) {
            val celsius = (deger - 32) * 5 / 9
            sonuc = "x :" + deger + " = y: " + celsius

        } else if (secim == 2) {
            val fahrenheit = (deger * 9 / 5) + 32
            sonuc = "x :" + deger + " =  y: " + fahrenheit

        } else {
            println(" Hatalı Seçim Yaptınız! ")
        }
    }
    return sonuc
}

/**
 * 3 - Kullanıcıdan 2 Sayı Alıyorsunuz
 * 	Bu 2 Büyük ve Küçük Olanını Ekrana Bastırıyorsunuz
 * 	Eğer Sayılar Eşitse Sayılar Eşittir Mesajını
 * 	Ekrana Bastırıyorsunuz
 */
fun sayiDurumu(sy1: Int, sy2: Int): String {
    var sayiMesaj = ""
    if (sy1 > sy2) {
        sayiMesaj = " Büyük sayı : $sy1 , Küçük sayı : $sy2 "
    } else if (sy2 > sy1) {
        sayiMesaj = " Büyük sayı : $sy2 , Küçük sayı : $sy1 "
    } else if (sy1 == sy2) {
        sayiMesaj = " Sayılar Eşittir! "
    } else {
        sayiMesaj = "Hatalı İşlem"
    }
    return sayiMesaj
}

/**
 * 4 - Kullanıcıdan Bir N Sayısı Alıyorsunuz
 * 	1'den N'e Kadar Olan Sayıların Toplamını
 * 	Ekrana Bastırıyorsunuz (Formulü Araştırın)
 */

fun sayiToplam(nSayi: Int): String {
    val toplam = nSayi * (nSayi + 1) / 2
    val toplamMesaj = " 1'den $nSayi sayısına kadar olan sayıların toplamı : $toplam "
    return toplamMesaj
}

/**
 * 5 - Kullanıcıdan 3 Haneli Bir Sayı
 * 	Alıyorsunuz. Bu Sayının
 * 	Basamaklarının Toplamını
 * 	Yazdırıyorsunuz
 *
 * 	Örnek :
 * 	Sayı Girin : 245
 * 	2 + 4 + 5 = 11
 */

fun basamakToplam(sayiDeger: Int): String {

    val sayiDeger =
        if (sayiDeger < 0) -1 * sayiDeger else sayiDeger  // sayı negatifse pozitife çevirir
    var toplamMesaj: String = ""
    var toplam = 0

    if (sayiDeger in 100..999) {

        var sayi = sayiDeger

        while (sayi != 0) {
            val basamak = sayi % 10  // mod ile kalan alındı. yani 1 ler basamağı
            toplam += basamak
            sayi /= 10  // sayının bölüm kısmı yani sonucu alındı
        }
        toplamMesaj = "Sayının basamak değerleri toplamı :" + toplam
        return toplamMesaj
    } else {
        toplamMesaj = "Üç basamaklı bir sayı giriniz!"
        return toplamMesaj
    }
}

/**
 * 6 - Kullanıcıdan 3 Haneli Bir Sayı
 * 	Alıyorsunuz. Bu Sayının
 * 	Rakamlarını Tersten Yazdırıyorsunuz
 * 	Örnek :
 * 	Sayı Girin : 743
 * 	347
 */

fun sayiTersYaz(sayiYaz: Int): String {
    val tersSayi = sayiYaz.toString() // sayı String'e çevrildi
    var ters = 0
    var mesaj = " "

    if (tersSayi != null && tersSayi.length == 3) {    // sayının 3 bas. olma durmu kontrol edildi
        val tersStr = tersSayi.reversed()              //terse çevrildi
        ters = tersStr.toInt()                         // tekrardan int e dönüştürüldü
        mesaj = " " + ters
    } else {
        mesaj = " Geçersiz giriş ! "

    }

    return mesaj
}

/**
 * 7 -	Kullanıcıdan Kac Sayi Girecegini Ogren (N)
 *     Kullanıcıdan N Tane Sayı Al
 *
 *     Sayı Girişi Bittikten Sonra Aşağıdakine Benzer Bir Rapor Olustur
 *     Girilen 17 Sayıdan :
 *     8 Tanesi Pozitif
 *     6 Tanesi Negatif
 *     En Büyüğü : 67
 *     En Küçüğü : -9
 *     10 Tanesi Çift
 *     7 Tanesi Tek
 *     Toplamları : 567
 *     Ortalamaları : 33,345
 */

fun nSayiRaporu(sayiAdedi: Int, girilenSayilar: IntArray): String {

    var raporMesaji = ""
    val negatifSayilar = ArrayList<Int>()
    val pozitifSayilar = ArrayList<Int>()
    var enBuyukSayi = 0
    var enKucukSayi = 0
    var sayac = 0
    var ciftSayi = 0
    var tekSayi = 0
    var toplam = 0
    var ortalama: Any = 0
    var formatliOrtalama: Any = 0

    for (eleman in girilenSayilar) {

        if (sayac == 0) {
            enKucukSayi = eleman
        }
        if (eleman > enBuyukSayi) {
            enBuyukSayi = eleman
        }
        if (eleman < enKucukSayi) {
            enKucukSayi = eleman
        }
        if (eleman < 0) {
            negatifSayilar.add(eleman)
        } else {
            pozitifSayilar.add(eleman)
        }
        if (eleman % 2 == 0) {
            ciftSayi++
        } else {
            tekSayi++
        }
        sayac++

        toplam += eleman
        ortalama = toplam.toDouble() / sayiAdedi
        formatliOrtalama = String.format("%.3f", ortalama)
    }

    raporMesaji =
        "Girilen " + sayiAdedi + " Sayıdan: \n " +
                pozitifSayilar.count() + " Tanesi Pozitif \n" +
                negatifSayilar.count() + " Tanesi negatif \n" +
                "En Büyüğü : " + enBuyukSayi + " \n " +
                "En Küçüğü : " + enKucukSayi + " \n " +
                ciftSayi + " tanesi çift " + " \n " +
                tekSayi + " tanesi tek " + " \n " +
                "Sayıların toplamı : " + toplam + " \n " +
                "Ortalama :  " + formatliOrtalama + " \n "

    return raporMesaji
}
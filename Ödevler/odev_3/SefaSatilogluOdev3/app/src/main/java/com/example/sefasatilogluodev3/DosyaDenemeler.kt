package com.example.sefasatilogluodev3

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import kotlin.random.Random

fun main() {

    val dosyaYolu = ""
    val dosyaYolu2 = "C:\\Users\\sefas\\OneDrive\\Masaüstü\\merhaba.txt"
    //File(dosyaYolu) ifadesi ile bu dosya yoluna sahip bir File nesnesi olustururuz.
    val dosya = File(dosyaYolu)
    val dosya2 = File(dosyaYolu2)
    //Exists method ise var mı yok mu diye kontrol eder.
    if (dosya.exists()) {
        println("Dosya Mevcut!")
    }else {
        println("Dosya Bulunamadi!")
    }
    //Sonucumuz dosya bulunamadi. Uygun bir dosya yolu belirtirsek eger dosyayi bulacaktir.
    //Ornek yapalim bir dosya yolu belirtelim.
    //Dosya Okuma
    val dosyaOkuma = dosya2.readLines()
    println(dosyaOkuma) // satir satir bir liste halinde okuma islemi yaptik.
    //Dosya yazma
    //daha once yazdigimiz dosyada ki yazilar gider write methodunu kullanirsak uzerine yazar
    /*
    val dosyaYazma = FileWriter(dosya2)
    dosyaYazma.write("Write \n Methodunu Kullanma")
    dosyaYazma.close()
    */
    for (i in dosyaOkuma) {
        println("$i ---- Toplam uzunlugu: ${i.length}")

    }
    //Dosyanin icerigini bu sekilde temizleyebiliriz.
    //dosya2.writeText("")
    //println(dosyaOkuma)

    //Random Sayi Uretme
    //val dosyaYazma = PrintWriter(dosyaYolu2) // PrintWriter methodu olusturuyoruz.Dosya yolunu veriyoruz.Bu dosyanin icine yazma islemi yapacagiz diye
    for (i in 1..500) {
        val randomNumber = Random.nextInt(1,1000) // 1 ile 1000 arasinda random sayi üretir.
        //dosyaYazma.println(randomNumber) // Olusturdugumuz printWriter methodunu println ile dosyanin icine yaziyoruz.
        println(randomNumber)
    }
    //dosyaYazma.close()
    //yazdirdigimiz dosyayi her seferinde kapatma islemi yapmayi unutmamiz gerekiyor!
    //Dosya olusturma
    val denemeDosyaOlusturma = File("Deneme.txt")
    val denemePrint = PrintWriter(denemeDosyaOlusturma)
    denemePrint.println("sefa deneme dosya olusturma.\n alt satira indim \n yeni bir satir olusturdum.")
    denemePrint.close()










}
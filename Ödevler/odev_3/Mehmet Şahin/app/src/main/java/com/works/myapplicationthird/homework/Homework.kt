package com.works.myapplicationthird.homework

import androidx.core.text.isDigitsOnly
import java.io.File
import java.lang.Math.multiplyExact
import java.lang.Math.pow
import java.util.Scanner
import kotlin.random.Random

fun main(args: Array<String>) {

    /*  Notepad++ İle Bir Dosya Oluşturun
İçine 15 Tane Sayı Yazın (Arada Pozitif, Negatif Sayılarda Olsun)
Uygulamanıza Bu Dosyanın Yolunu Vereceksiniz.Uygulamanız Ekrana
Dosyada Kaç Tane :
- Pozitif
- Negatif
- Tek
- Çift Sayı Olduğunu Bastıracak.
    * */

    //Soru 1
    val dizin = File("C:\\Users\\KotlinTurkcell\\Desktop\\Text")
    val dosyaYolu = File(dizin, "newText.txt")

    //Dosya varligi kontrol
    if(!dosyaYolu.exists()) {
        println("Dosya yolu bulunamadı!")
    }else {
        try{
            val icerik = dosyaYolu.readLines()
            val tamsayi = mutableListOf<Int>()
            icerik.forEach {
                try{
                    //Tam sayıya dönüstürme ve dönüstürme hata kontrol
                    val icerikSayi = it.toInt()
                    tamsayi.add(icerikSayi)
                }catch(ex: Exception) {
                    println("Hata! Tam sayi dönüşümü yapılamadı ${ex.message}")
                }
            }
            //Sayilari filtreleme ve sayma
            val ciftSayi = tamsayi.filter { it %2 == 0 }.size
            val tekSayi = tamsayi.filter { it %2 != 0 }.size  //Negatifte almalı
            val pozitifSayi = tamsayi.filter { it > 0 }.size
            val negatifSayi = tamsayi.filter { it < 0 }.size

            println("Çift sayıların adedi: $ciftSayi")
            println("Tek sayiların adedi: $tekSayi")
            println("Negatif sayiların adedi: $negatifSayi")
            println("Pozitif sayiların adedi: $pozitifSayi")

        }catch(ex : Exception) {
            println("Hata! ${ex.message}")
        }
    }




    /*1. Sorudaki Dosyayı -1000, +1000 Arası 500 Tane Random Sayıyla Dolduran Bir Uygulama Yazın.
    * */

    //2.Soru
    //Random sayi üretme
    val randomSayilar = List(500) { Random.nextInt(-1000,1001) }
    try {
        //Doğrudan üzerine yazma writeText()
        //appendText() dosyanın sonundan başlayarak ekleme
        dosyaYolu.writeText(randomSayilar.joinToString("\n"))
        println("-1000 ve 1000(dahil) arasında 500 adet random sayı işlendi")
    }catch (ex: Exception) {
        println("Hata! : ${ex.message}")
    }



    /*2. Soruda Oluşturduğunuz Dosyayı Açıp Okuyan, Input Dosyasının Bulunduğu Klasore
    C.txt Adında Bir Dosya Oluşturup, Input Dosyasının İçindeki Cift Sayıları Yazan,
    T.txt Adında Bir Dosya Olusturup, Tek Sayıları Yazan Bir Uygulama Yazın
    * */

    //3.soru

    val ciftSayilar = mutableListOf<Int>()
    val tekSayilar = mutableListOf<Int>()

    //Çift ve tek sayıları ayırıp liste ekleme işlemi
    for ( item in randomSayilar) {
        if( item %2 == 0) ciftSayilar.add(item)
        if(item %2 !=0) tekSayilar.add(item)
    }

    val dosyaCift = File(dizin, "C.txt")

    try {
        val ciftDosyaOlusturma = dosyaCift.createNewFile()
        dosyaCift.writeText(ciftSayilar.joinToString ("\n"))
    }catch(ex: Exception) {
        println("Hata! Çift sayılar dosyası oluşturulamadı")
    }

    val dosyaTek = File(dizin, "T.txt")

    try {
        val tekDosyaOlusturma = dosyaTek.createNewFile()
        dosyaTek.writeText(tekSayilar.joinToString ("\n"))
    }catch (ex: Exception) {
        println("Hata! Tek sayılar dosyası oluşturulamadı")
    }


    /*İçindeki dump.txt Dosyasını Masaüstüne Çıkartın.
    Uygulamaya Bu Dosyayı Okuttuğunuz Zaman,
    Bu Dosyada Kaç Satır, Kaç Kelime Var,
    Harflerin Kaçı Sessiz, Kaçı Sesli Bu Bilgileri Konsola Yazan Bir Uygulama Yazın
    * */

    //4.Soru
    val dosyaDump = File(dizin,"dump.txt")
    try {
        val dosyaTxt = dosyaDump.readText().lowercase()
        val satir = dosyaTxt.split("\n")
        val satirSayisi = satir.size

        val kelimeSayisi = dosyaTxt.split(" ").size
        val sesliHarf = dosyaTxt.filter { it.isLetter() && !it.isWhitespace() && it.lowercase() in "aeoöuiıü"}.count() //Tr dahil
        val sessizHarf = dosyaTxt.filter { it.isLetter() && !it.isWhitespace() && it.lowercase() !in "aeoöuiıü"}.count()

        println("Dump.txt içindeki satır sayısı : $satirSayisi")
        println("Dump.txt içindeki kelime sayısı : $kelimeSayisi")
        println("Dump.txt içindeki sesli harf sayısı : $sesliHarf")
        println("Dump.txt içindeki sessiz harf sayısı : $sessizHarf")
    }catch (ex: Exception) {
        println("Hata! Dosya işleme sırasında hata oluştu ${ex.message}")
    }


    /*  4. Sorudaki dump.txt yi, dump_rev_1.txt Dosyasına Tersten Yazdırın
    * */

    //5.Soru
    val dumpRevYolu = File(dizin, "dump_rev_1.txt")

    try {
        val newDumpRev = dumpRevYolu.createNewFile()
        val dumpReverse = dosyaDump.readText().reversed()
        val yazici = dumpRevYolu.writeText(dumpReverse)
        println("Dump.txt içeriğinin tersi yazıldı")
    }catch (ex: Exception) {
        println("Hata! Dosya işleme sırasında hata oluştu : ${ex.message}")
    }


    /*  4. Sorudaki dump.txt yi, dump_rev_2.txt Dosyasına, Kelime Sırasını Bozmadan Tersten Yazdırın
    * */

    //6.Soru
    val tersYol = File(dizin, "dump_rev_2.txt")
    try {
        val dumpRev2 = tersYol.createNewFile()
        var bosStr = " "
        val dump = dosyaDump.readText().split(" ").forEach{
            // Daha düzenli bir görünüm için sadece kelimeleri alıp ters çevirdik
            val tersKelime = it.filter { it.isLetter() }.reversed()
            // Her seferinde boş Stringe yazdırma ve  boşluk ekleme
            bosStr += tersKelime + " "
        }
        val tersKelime = bosStr.trim()
        val dumpRevYazdir = tersYol.writeText(tersKelime)
        println("Kelime sırası değiştirilmeden dosyaya yazıldı")
    }catch (ex: Exception) {
        println("Hata! Dosya işlemede hata oluştu : ${ex.message}")
    }



    /* 4. Sorudaki dump.txt'de Her Kelimeden Kaç Kez Geçtiğini,
    En Uzun Kelimenin Hangisi Olduğunu, Kaç Harf Olduğunu
    En Kısa Kelimenin Hangisi Olduğunu ve Kaç Harf Olduğunu Ekrana Bastırın
    * */

    //7.Soru

    //Dosyanın içeriğini alarak boşluk karakterlerine ayırır bir list döner
    val dumpList = dosyaDump.readText().split(Regex("\\s+"))
    try {
        //Her kelimeyi gruplar kaç kez geçtiğini hesaplar map döner
        //forEach ile her kelimenin tekrar sayısını alıp yazdırıyoruz
        val kelimeTekrari = dumpList.groupingBy { it }.eachCount().forEach{(kelime, tekrar) ->
            println("$kelime: $tekrar")
        }

        //Boş olmayan kelimeleri filtreleyip kelimenin uzunluğuna göre sıralıyoruz
        val enKisaKelime = dumpList.filter {it.isNotEmpty()}.minByOrNull { it.length }
        val enUzunKelime = dumpList.filter{it.isNotEmpty()}.maxByOrNull { it.length }
        //Kısa ve uzun kelimenin uzunluğunu alıyoruz, Null dolayısıyla ? ekledik
        val kisaUzunluk = enKisaKelime?.length
        val uzunUzunluk = enUzunKelime?.length

        println("""
        En Kısa Kelime: $enKisaKelime'dir içinde $kisaUzunluk adet harf vardır
        En uzun Kelime: $enUzunKelime'dir içinde $uzunUzunluk adet harf vardır
    """.trimIndent())
    }catch(ex: Exception) {
        println("Hata! Dosya işlenemedi: ${ex.message}")
    }




    /* Kullanıcıdan Bir Klasörün Yolunu Alın.
    O Klasör ve O Klasörün Altındaki Tüm Klasörlerde Dahil Olmak Üzere
    (Burada Recursive Bir Method Yazmanız Gerek)
    Toplam Boyutu Bulup Ekrana Yazdırın
    * */

    println("=============================")
    println("Klasör/Alt Klasör Toplam Boyutunu hesaplama")
    //8.Soru
    val scanner = Scanner(System.`in`)
    println("Lütfen klasör yolunu giriniz: ")
    val kullaniciGirisi = scanner.next()

    val dosyaYolu1 = File(kullaniciGirisi)

    //Dosyanın varlığını ve klasör olup olmadığının kontrolü
    if(dosyaYolu1.exists() && dosyaYolu1.isDirectory) {
        val fncByt = boyutHesaplama(dosyaYolu1)
        val fncMB = fncByt/pow(1024.0,2.0)
        val fncGB = fncMB/1024
        println("""
        Klasörlerin byte cinsinden toplam boyutu: $fncByt
        Klasörlerin megabyte cinsinden toplam boyutu: $fncMB
        Klasörlerin megabyte cinsinden toplam boyutu: $fncGB
    """.trimIndent())
    } else {
        println("Belirtilen klasör bulunamadı")
    }


    /* Kullanıcıdan Bir Kelime Alın
    8. Sorudaki Recursive Dosya Dolaşma Mantığıyla, Dosya Adında Kullanıcının Girmiş Olduğu Kelimeyi İçeren
    Dosyaların;
    Arama Sonucu Kaç Dosyanın Bulunduğunu,
    Adını,
    Bulunduğu Klasörü
    Boyutunu Ekrana Bastırın
    * */


    //9.soru
    println("Lütfen klasör yolunu giriniz: ")
    val klasorGiris = readln()
    println("Lütfen kelimeyi giriniz: ")
    val kelimeGiris = readln()

    val klasorF = File(klasorGiris)
    //Klasörün varlığı ve olup olmadığının kontrolü
    if(klasorF.exists() && klasorF.isDirectory) {
        kelimeEslesme(klasorF, kelimeGiris)
    }else{
        println("Belirtilen klasör bulunamadı")
    }



}


//8.Soru

fun boyutHesaplama (yolDosya: File): Long {
    var boyut: Long = 0
    //walkTopDown klasörün içindeki tüm dosyaları dolaşıp boyutlarını toplayarak alıyoruz
    //listFiles'ta kullanılabilir
    val klasorler = yolDosya.walkTopDown().forEach {
        boyut += it.length()
    }
    return boyut
}


//9.soru

fun kelimeEslesme (klasor: File, kelime: String) {
    var sayac = 0
    klasor.walkTopDown().forEach {
        if(kelime.lowercase() in it.name.lowercase()) {
            sayac++
            println("""
                Dosyanin adı: ${it.name}
                Dosya Yolu: ${it.parent}
                Dosya Byte Boyutu: ${it.length()}
                Dosya MegabyteBoyutu: ${it.length() / pow(1024.0, 2.0)}
            """.trimIndent())
            }
        }
    println("Kelimeyi içeren $sayac adet dosya eşleşti")
}








package com.example.sefasatilogluodev3

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.PrintWriter
import java.util.Scanner
import kotlin.random.Random

fun main() {

    /*
    Soru-1 : Notepad++ İle Bir Dosya Oluşturun
    İçine 15 Tane Sayı Yazın (Arada Pozitif, Negatif Sayılarda Olsun)

    Uygulamanıza Bu Dosyanın Yolunu Vereceksiniz.Uygulamanız Ekrana
    Dosyada Kaç Tane :
    - Pozitif
    - Negatif
    - Tek
    - Çift Sayı Olduğunu Bastıracak.
     */

    // Dosya olusturma
    //val dosya = File("dosya.txt")
    //dosya.createNewFile()



    //Dosya yazma
    /*val fileWriter = FileWriter(dosya)
    fileWriter.write(sayilar.toString())
    fileWriter.close()*/


    //Dosya okuma (readText methoduyla da okuyabiliriz)
    /*val data = dosya.readText()
    println(data)*/
    /*
    dosya.forEachLine {
        println(it)
    }
     */
    val dosyaYolu = "C:\\Users\\sefas\\OneDrive\\Masaüstü\\sayilar.txt"
    var pozitifSayilar = 0
    var negatifSayilar = 0
    var ciftSayilar = 0
    var tekSayilar = 0
    val dosya = File(dosyaYolu)
    val dosyaOkuma = dosya.readLines()
    for (i in dosyaOkuma) {
        val sayi = i.toInt()
        if (sayi>0) pozitifSayilar++
        if (sayi <0)negatifSayilar++
        if (sayi % 2 == 0) ciftSayilar++
        else tekSayilar++
    }
    println("""
        
        Dosya iceriği!
        
        -Pozitif Sayisi $pozitifSayilar
        -Negatif Sayisi $negatifSayilar
        -Tek Sayi $tekSayilar
        -Cift Sayi $ciftSayilar        
    """.trimIndent())

    //2.Soru  1. Sorudaki Dosyayı -1000, +1000 Arası 500 Tane Random Sayıyla Dolduran Bir Uygulama Yazın.

    //Dosyanin icerigini temizleme
    File(dosyaYolu).writeText("")

    //Dosyaya yazma
    try {
        val printWriter = PrintWriter(dosyaYolu)
        for (i in 1..500) {
            val randomNumber = Random.nextInt(2001)-1000
            printWriter.println(randomNumber)//dosyaya yazma islemi
        }
        println("Dosya yazildi!")
        printWriter.close()//Yazma islemi yaptiktan sonra dosyayi kapatma

    }catch (e:Exception) {
        println("Dosyaya yazilmadi!")
    }

    /* 3.Soru
    2. Soruda Oluşturduğunuz Dosyayı Açıp Okuyan, Input Dosyasının Bulunduğu Klasore
    C.txt Adında Bir Dosya Oluşturup, Input Dosyasının İçindeki Cift Sayıları Yazan,
    T.txt Adında Bir Dosya Olusturup, Tek Sayıları Yazan Bir Uygulama Yazın
     */
    //Dosyayi okuma
    try {
        val dosyaOkuma2 = File(dosyaYolu).readLines()
        //Dosya olusturma
        val ciftsayilarDosyasi = File("C.txt")
        val tekSayilarDosyasi = File("T.txt")
        //Dosya yazma
        val ciftprintWriter = PrintWriter(ciftsayilarDosyasi)
        val tekprintWriter = PrintWriter(tekSayilarDosyasi)
        for (i in dosyaOkuma2) {
            val sayi = i.toInt()
            if (sayi % 2 == 0 ) {
                ciftprintWriter.println(sayi)
            }else{
                tekprintWriter.println(sayi)
            }
    }
        println("Dosyalar Olusturuldu!")
        ciftprintWriter.close()
        tekprintWriter.close()

    }catch (e :Exception) {
        println("Dosya Yazilamadi!")
    }
    /*
    4.Soru Uygulamaya Bu Dosyayı Okuttuğunuz Zaman,
    Bu Dosyada Kaç Satır, Kaç Kelime Var,
    Harflerin Kaçı Sessiz, Kaçı Sesli Bu Bilgileri Konsola Yazan Bir Uygulama Yazın
     */

    //Dosya okuma
    val dosyaYolu1 = "C:\\Users\\sefas\\OneDrive\\Masaüstü\\dump.txt"
    try {
        val file = File(dosyaYolu1)
        //Dosya Satir Bulma
        val satirSayisi = file.readLines().size
        println("Dosyada ki toplam satir sayisi: $satirSayisi")
        //Kelime sayisini bulma
        val dosyaOkuma = file.readText()
        val kelimeSayisi = dosyaOkuma.split(Regex("\\s+")).size
        println("Dosyada ki toplam kelime sayisi: $kelimeSayisi")
        //Sesli Sessiz Harf Bulma
        var sessizHarf = 0
        var sesliHarf = 0
        for (harf in dosyaOkuma) {
            val kucukHarf = harf.toLowerCase()
            if (kucukHarf in "bcdfgğhjklmnpqrstvwxyz") {
                sessizHarf++
            }else if (kucukHarf in "aeıioöuü") {
                sesliHarf++
            }
        }
        println("Sessiz Harf Sayisi: $sessizHarf")
        println("Sesli Harf Sayisi: $sesliHarf")



    }catch (e:Exception) {
        println("Dosya bulunamadi!")
    }

    // 5.Soru 4. Sorudaki dump.txt yi, dump_rev_1.txt Dosyasına Tersten Yazdırın

    try {
        val file1 = File(dosyaYolu1)
        val dosyaOkuma = file1.readText()
        //Dosya olusturma
        val dosyaOlusturma = File("dump_rev_1.txt")
        dosyaOlusturma.createNewFile() // dosya olusturma
        //Dosya icerigine tersten yazdirma
        val fileWriter = FileWriter(dosyaOlusturma)
        fileWriter.write(dosyaOkuma.reversed())
        fileWriter.close()
        println("Dosya olusturuldu!")

    }catch (e:Exception) {
        println("Dosya Bulunamadi!")
    }
    //6.Soru 4. Sorudaki dump.txt yi, dump_rev_2.txt Dosyasına, Kelime Sırasını Bozmadan Tersten Yazdırın

    try {
        val file2 = File(dosyaYolu1)
        //dosya olsuturma
        val dosyaOlusturma2 = File("dump_rev_2.txt")
        dosyaOlusturma2.createNewFile()
        val dosyaOkuma1 = file2.readText()
        val kelimelereAyirma = dosyaOkuma1.split(" ")



        for (kelime in kelimelereAyirma) {
            //Dosya yazma
            val fileWriter2 = FileWriter(dosyaOlusturma2,true) // sonuna ekleme yapmasi için mevcut dosyayi korumasi için true yaziyoruz
            var revKelime = kelime.reversed()
            fileWriter2.write(revKelime + " ") // Her kelimenin sonuna bosluk ekliyoruz kelimeler arasinda bosluk olsun
            fileWriter2.close()

        }

        println("Yeni $dosyaOlusturma2 Dosyasi Olusturuldu  ")

    }catch (e:Exception) {
        println("Dosya olusturulmadi!")
    }
    //7.Soru 4. Sorudaki dump.txt'de Her Kelimeden Kaç Kez Geçtiğini,
    //En Uzun Kelimenin Hangisi Olduğunu, Kaç Harf Olduğunu
    //En Kısa Kelimenin Hangisi Olduğunu ve Kaç Harf Olduğunu Ekrana Bastırın
    val file3 = File(dosyaYolu1)
    try {

        //Dosya Okuma
        val dosyaOkuma = file3.readText()
        //Bosluksuz ve noktalama isaretlerini temizlemek icin regex kullaniyoruz
        val kelimeler = dosyaOkuma.split(Regex("[\\s,.]+"))
        //Kelimeleri saklamak icin map olusturma
        var enUzunKelime = ""
        var enKisaKelime = kelimeler.firstOrNull() ?:"" // ilk kelimeyi al eger ilk kelime yoksa bos kelime doner
        val kelimeSayisi = mutableMapOf<String,Int>()
        for (kelime in kelimeler) {
            //kucuk harflere cevirme
            val kelimeKucuk = kelime.toLowerCase()
            //Eger kelime bos degilse sayiyi artırma
            //kelime harf sayisi
            val kelimeHarfSayisi = kelime.length
            kelimeSayisi[kelime] = kelimeHarfSayisi
            if (kelimeHarfSayisi > enUzunKelime.length ) {
                enUzunKelime = kelime
            }
            if (kelimeHarfSayisi > 0 && (enKisaKelime.isEmpty() || kelimeHarfSayisi < enKisaKelime.length) ) {
                enKisaKelime = kelime
            }
            //isNotBlank() fonksiyonu, bir dizenin boş olup olmadığını kontrol eder ve boş değilse true, boşsa false döndürür.
            if (kelimeKucuk.isNotBlank()) {
                kelimeSayisi[kelimeKucuk] = kelimeSayisi.getOrDefault(kelimeKucuk,0)+1 //Bu kelimenin kaç kere geçtiğini saymak için kullanılıyor.
            }

        }


        //Map yapisinda key value yazdirma islemleri yapiyoruz.
        kelimeSayisi.forEach { kelime, sayi ->
            println("$kelime: $sayi")
            println("En uzun kelime sayisi: ${kelime.length}")
        }
        println("En uzun kelime $enUzunKelime Harf Sayisi: ${enUzunKelime.length}")
        println("En kisa kelime $enKisaKelime Harf Sayisi: ${enKisaKelime.length}")

    }catch (e:Exception) {
        println("Guvende Kal!")
    }
    /*
    8.Soru Kullanıcıdan Bir Klasörün Yolunu Alın.
    O Klasör ve O Klasörün Altındaki Tüm Klasörlerde Dahil Olmak Üzere
    (Burada Recursive Bir Method Yazmanız Gerek)
    Toplam Boyutu Bulup Ekrana Yazdırın

     */
    //Kullanicidan klasor yolunu aliyoruz.
    val girdi = Scanner(System.`in`)
    println("Lütfen bir klasör yolunu girin:")
    val klasorYolu = girdi.next()
    //Dosyayi olusturuyoruz
    val klasor = File(klasorYolu)
    //Dosyalarda kullanilan exists komutuyla klasör var mi yok mu diye kontrol ediyoruz
    //isDirectory methodu ise bir dizin değilse veya var olmayan bir yolu temsil ediyorsa bir uyarı mesajı yazdırmak için kullanılmıştır.
    if (!klasor.exists() || !klasor.isDirectory) {
        println("Belirtilen klasör bulunamadı veya klasör değil.")
        return
    }
    //Toplam boyutu alma
    val toplamBoyut = klasorBoyutunuHesapla(klasor)
    //byte cinsinden
    println("Klasörün toplam boyutu: ${toplamBoyut}")
    //byte kb,mb,gb donusturme
    val kiloByte = toplamBoyut / 1024.0
    val megaByte = kiloByte / 1024.0
    val gigaByte = megaByte / 1024.0
    println("Klasörün Toplam Boyutu(KiloByte Cinsinden): ${"%.2f KB".format(kiloByte)}")
    println("Klasörün Toplam Boyutu(MegaByte Cinsinden): ${"%.2f MB".format(megaByte)}")
    println("Klasörün Toplam Boyutu(GigaByte Cinsinden): ${"%.2f GB".format(gigaByte)}")



    /*
    9. Kullanıcıdan Bir Kelime Alın
    8. Sorudaki Recursive Dosya Dolaşma Mantığıyla, Dosya Adında Kullanıcının Girmiş Olduğu Kelimeyi İçeren
    Dosyaların;

    Arama Sonucu Kaç Dosyanın Bulunduğunu,
    Adını,
    Bulunduğu Klasörü
    Boyutunu Ekrana Bastırın
     */

    val scanner = Scanner(System.`in`)
    println("Lütfen aramak istediğiniz kelimeyi girin:")
    val arananKelime = scanner.nextLine().toLowerCase()

    // Dosya listesini al
    //listFilesRecursively fonksiyonu, verilen dizinde (ve alt dizinlerinde) belirtilen kelimeyi içeren dosyaların listesini döndürür.
    val dosyaListesi = dizinleriYazdir(File("."), arananKelime) // mevcut dizine ulasiriz "." ile

    println("Arama Sonucu:")
    println("Toplam Bulunan Dosya Sayısı: ${dosyaListesi.size}")

    for (dosya in dosyaListesi) {
        println("Dosya Adı: ${dosya.name}")
        println("Bulunduğu Klasör: ${dosya.parent}")
        println("Boyutu: ${dosya.length()}")
    }


}
fun klasorBoyutunuHesapla(klasor: File): Long {
    var toplamBoyut = 0L
    //Dosya olup olmadigini kontrol eder. isDirectory methodu ile eger dosya ise true döner
    if (klasor.isDirectory) {
        val dosyalar = klasor.listFiles()//listFiles() metodu, bu klasörün içindeki dosyaları ve alt klasörleri döndürür.

        if (dosyalar != null) {
            for (dosya in dosyalar) {
                if (dosya.isDirectory) {
                    toplamBoyut += klasorBoyutunuHesapla(dosya) // eger dosya varsa fonksiyonu cagirir ve toplam boyuta ekler
                } else {
                    toplamBoyut += dosya.length() // eger bir dosya varsa o dosyanin boyunu alir ve toplam boyuta gonderilir.
                }
            }
        }
    }

    return toplamBoyut // tum icerisinde bulunan dosyalarin boyutunu dondurur.
}
fun dizinleriYazdir(dosya: File, arananKelime: String): List<File> {
    val dosyaListesi = mutableListOf<File>()

    if (dosya.isDirectory) {
        //dosya.listFiles() fonksiyonu, belirtilen dosya nesnesinin içindeki dosya ve dizinleri bir dizi olarak döndürür.
        val dosyalar = dosya.listFiles()
        if (dosyalar != null) {
            for (altDosya in dosyalar) {
                //addAll: Bir liste nesnesine başka bir listenin içeriğini eklemek için kullanılan bir metoddur.
                dosyaListesi.addAll(dizinleriYazdir(altDosya, arananKelime))
            }
        }
    } else {
        //contains icerip icermedigini kontrol eder.
        if (dosya.name.toLowerCase().contains(arananKelime)) {
            dosyaListesi.add(dosya)
        }
    }

    return dosyaListesi
}

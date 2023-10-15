package com.example.esmasalkim_dosyaislemleri_odev3

import java.io.File
import java.io.FileWriter
import java.lang.Exception
import java.util.Random
import java.util.Scanner

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
}

val dosyaYolu = "C:\\Users\\Esma\\Desktop\\Esma_Salkım\\soru1.txt.txt"
val dosya = File(dosyaYolu)
val scanner = Scanner(dosya)



    fun soru1 () {

        var pozitifSayac = 0
        var negatifSayac = 0
        var ciftSayi = 0
        var tekSayi = 0

        while (scanner.hasNextLine()) {
            val satir = scanner.nextLine()
            try {
                val sayi = satir.toInt() // Satırı sayıya çevir
                println(sayi)

                if (sayi > 0) {
                    pozitifSayac++
                } else  {
                    negatifSayac++
                }
                if (sayi % 2 == 0) {
                    ciftSayi++
                } else {
                    tekSayi++
                }
            } catch (e: NumberFormatException) {
                println("Geçersiz sayı: $satir")
            }
        }
        //scanner.close()
        println("Pozitif Sayılar : $pozitifSayac adet")
        println("Negatif Sayılar : $negatifSayac adet")
        println("Çift Sayılar : $ciftSayi adet")
        println("Tek Sayılar : $tekSayi adet")
    }

fun soru2(){

    File (dosyaYolu).writeText("")

    val random = Random()

    val minSayi = -1000
    val maxSayi = 1000
    val yazilacakSayi = 500

    try {
        val dosyaYaz = FileWriter (dosya)
        for ( i in 1..yazilacakSayi) {
            val rastgeleSayi = random.nextInt(maxSayi - minSayi + 1) + minSayi
            dosyaYaz.write("$rastgeleSayi \n")
        }
        dosyaYaz.close()
        println("Rastgele sayılar $dosyaYolu ' na yazıldı..")
    }catch (ex:Exception){
        println(ex.message)
    }
}

fun soru3() {

    val ciftSayilarDosyaYolu = File ("C:\\Users\\Esma\\Desktop\\Esma_Salkım\\C.txt.txt")
    val tekSayilarDosyaYolu = File ("C:\\Users\\Esma\\Desktop\\Esma_Salkım\\T.txt.txt")
    val ciftSayilar = mutableListOf<Int>()
    val tekSayilar = mutableListOf<Int>()

    try {

            if (dosya.exists()) {

                dosya.forEachLine { it ->
                    val sayi = it.trim().toInt()

                    if (sayi != null) {
                        if (sayi % 2 == 0) {
                            ciftSayilar.add(sayi)
                        } else {
                            tekSayilar.add(sayi)
                        }
                    }
                    }

                    ciftSayilarDosyaYolu.writeText(ciftSayilar.joinToString("\n"))
                    tekSayilarDosyaYolu.writeText(tekSayilar.joinToString("\n"))

                    println("Çift ve Tek sayılar ayrı dosyalara kaydedildi ! ")


             }else {
                println("$dosya adında bir dosya bulunamadı!")
            }

            }catch (ex:Exception){
                println(ex.message)
        }
}


fun soru4 () {

    val dosyaYolu = "C:\\Users\\Esma\\Desktop\\Esma_Salkım\\dump.txt"
    val dumpDosyaYolu = File(dosyaYolu)
    val satirlar = dumpDosyaYolu.readLines()
    val dosyaIcerik = dumpDosyaYolu.readText()

    var satirSayac = 0
    var sesliHarfSayac = 0
    var sessizHarfSayac = 0


    for (satir in satirlar) {
        satirSayac++
        print("$satir\n")
    }
    println("Dosyada $satirSayac satır var!")

    val kelimeSayisi = dosyaIcerik.split(Regex("\\s+")).size
    println("Dosyadaki Kelime Sayısı : $kelimeSayisi")

    val sessizHarfSayilari = mutableListOf<Char>('a', 'e', 'i', 'ı', 'o', 'ö', 'u', 'ü')

    for (harf in dosyaIcerik.trim()) {
        if (sessizHarfSayilari.contains(harf)) {
            sesliHarfSayac++
        } else {
            sessizHarfSayac++;
        }
    }
    println("Dosyadaki sesli harf sayısı : " + sesliHarfSayac )
    println("Dosyadaki sessiz harf sayısı : " + sessizHarfSayac )
}


fun soru5(){
    val dosyaYolu = "C:\\Users\\Esma\\Desktop\\Esma_Salkım\\dump.txt"
    val dumpDosyaYolu = File(dosyaYolu)
    val text = dumpDosyaYolu.readText()
    val dumpRevDosya = File ("C:\\Users\\Esma\\Desktop\\Esma_Salkım\\dump_rev_1.txt.txt")

if (dumpDosyaYolu.exists()) {
    val metin = text.reversed()
    dumpRevDosya.writeText(metin)
    println(" 'dump_rev_1.txt' dosyasına başarıyla tersten yazıldı! ")

}else{
    println("$dumpDosyaYolu Bulunamadı!")
}

}

fun soru6 (){
    val dosyaYolu = "C:\\Users\\Esma\\Desktop\\Esma_Salkım\\dump.txt"
    val dumpDosyaYolu = File(dosyaYolu)
    val text = dumpDosyaYolu.readText()
    val dumpRevDosya2 = File ("C:\\Users\\Esma\\Desktop\\Esma_Salkım\\dump_rev_2.txt.txt")
try {
    dumpRevDosya2.bufferedWriter().use { it ->

        val kelimeler = text.split(Regex("\\s+"))

        for (kelime in kelimeler){
            val tersKelime = kelime.reversed()
            it.write("$tersKelime ")
        }
        println(" 'dump_rev_1.txt' dosyasına kelimeler ters çevrilip başarıyla yazıldı! ")
    }
    }catch (ex:Exception){
          println("Hata Mesajı : " + ex.message)
}
}

fun soru7(){

    val dumpDosyaYolu = File("C:\\Users\\Esma\\Desktop\\Esma_Salkım\\dump.txt")
    val text = dumpDosyaYolu.readText()

    val kelimeler = text.split(Regex("[\\s,.]+"))
    var enUzunKelime = ""
    var enKisaKelime = kelimeler.firstOrNull()?.filter { it.isLetter() } ?: ""
    val kelimeSayilari = mutableMapOf<String, Int>()

    for (kelime in kelimeler) {

        val temizlenmisKelime = kelime.filter { it.isLetter() } // noktalama işaretleri temizlendi.
        val sayi = kelimeSayilari[temizlenmisKelime] ?:0
        kelimeSayilari[temizlenmisKelime] = sayi+1

        if (temizlenmisKelime.length > enUzunKelime.length) {
            enUzunKelime = temizlenmisKelime
        }
        if (temizlenmisKelime.isNotEmpty() && temizlenmisKelime.length < enKisaKelime.length) {
            enKisaKelime = temizlenmisKelime
        }
    }
    for ((kelime, sayi) in kelimeSayilari){
        println(" '$kelime' kelimesi $sayi kez geçiyor. ")
    }
    println("En uzun kelime : $enUzunKelime ")
    println("Karakter sayısı : ${enUzunKelime.length}")
    println("En kısa kelime : $enKisaKelime ")
    println("Karakter sayısı : ${enKisaKelime?.length}")
}


fun hesaplaDosyaBoyutu(dosya: File): Long {
    var boyut: Long = 0

    if (dosya.exists()) {
        val dosyalar = dosya.listFiles()

        if (dosyalar != null) {
            for (dosya in dosyalar) {
                if (dosya.isFile) {
                    boyut += dosya.length()
                } else if (dosya.isDirectory) {
                    boyut += hesaplaDosyaBoyutu(dosya)
                }
            }
        }
    }

    return boyut
}

fun  soru8(){
println("Boyutu bulunacak dosya yolunu giriniz")
    val dosyaUzantisi = readLine()
    if (dosyaUzantisi != null) {
        val klasor = File(dosyaUzantisi)
        val toplamBoyut = hesaplaDosyaBoyutu(klasor)

        println("Girdiğiniz klasörün içerisindeki dosyaların toplam boyutu: ${toplamBoyut / (1024 * 1024)} MB")
    } else {
        println("Geçersiz klasör yolu girdiniz.")
    }

}
fun soru9(){

    print("Girilecek dosya içerisinde aranacak kelimeyi giriniz: ")
    val girilenKelime = readLine()
    if (girilenKelime != null) {

        print("Girmiş olduğunuz : ${girilenKelime}  kelimesinin aranacağı dosya yolunu giriniz. ")
        val girilenDosyaYolu = readLine()

        if (girilenDosyaYolu != null) {
            val girilenDosya = File(girilenDosyaYolu)

            if (girilenDosya.exists() && girilenDosya.isDirectory ) {
                val bulunanDosyalar = DosyaIcerisindeKelimeHesabi(girilenDosya, girilenKelime)

                println("Girmiş olduğunuz dosyada aratmış olduğunuz kelimenin kullanıldığı ${bulunanDosyalar.size} dosya bulundu:")
                for (file in bulunanDosyalar) {
                    println("Dosya Adı: ${file.name}")
                    println("Bulunduğu Klasör: ${file.parent}")
                    println("Boyut: ${file.length()} bytes\n")
                }
            } else {
                println("Klasör bulunamadı. ")
            }
        } else {
            println("Geçersiz başlangıç klasörü yolu girdiniz.")
        }
    } else {
        println("Geçersiz kelime girdiniz.")
    }
}
fun DosyaIcerisindeKelimeHesabi(girilenDosya: File, girilenKelime: String): List<File> {
    val klasorListesi = mutableListOf<File>() // Kelimeyi içeren dosyaların atılacağı File list oluşturuldu

    if (girilenDosya.isDirectory) {
        val files = girilenDosya.listFiles()

        if (files != null) {
            for (file in files) {
                // Dosya direk bir dizin ismimi yoksa bir dosyanın kendisimi olduğu anlaşıldı.
                if (file.isDirectory) {
                    klasorListesi.addAll(DosyaIcerisindeKelimeHesabi(file, girilenKelime))
                // Dosyada kelimeyi aramak için recursive fonksiyon kullanıldı.Bu metot ise private bir metot olarak kullanıldı.
                } else if (file.isFile) {
                    if (file.name.contains(girilenKelime, ignoreCase = true)) {
                        klasorListesi.add(file)
                    }
                }
            }
        }
    }

    return klasorListesi
}


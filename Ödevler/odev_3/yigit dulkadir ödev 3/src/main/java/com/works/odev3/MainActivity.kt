package com.works.odev3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import java.util.Scanner

import kotlin.random.Random

import java.io.BufferedWriter
import java.io.FileWriter


import java.io.File

fun fun1(dosyaYolu: String): SayiSonuclari {
    val icerik = File(dosyaYolu).readLines()

    var pozitif = 0
    var negatif = 0
    var tek = 0
    var cift = 0

    icerik.forEach { satir ->
        val sayi = satir.trim().toInt()
        if (sayi > 0) pozitif++
        if (sayi < 0) negatif++
        if (sayi % 2 == 0) cift++
        else tek++
    }

    return SayiSonuclari(pozitif, negatif, tek, cift)
}

data class SayiSonuclari(
    val pozitif: Int,
    val negatif: Int,
    val tek: Int,
    val cift: Int
)

fun fun2(dosyaYolu: String) {
    val writer = BufferedWriter(FileWriter(dosyaYolu))

    repeat(500) {
        val rastgeleSayi = Random.nextInt(-1000, 1001)
        writer.write("$rastgeleSayi\n")
    }

    writer.close()
}


fun fun3(inputDosyaYolu: String) {
    val sayilar = File(inputDosyaYolu).readLines().map { it.trim().toInt() }

    val ciftSayilar = sayilar.filter { it % 2 == 0 }.joinToString("\n")
    val tekSayilar = sayilar.filter { it % 2 != 0 }.joinToString("\n")

    val klasorYolu = File(inputDosyaYolu).parent

    File("$klasorYolu\\C.txt").writeText(ciftSayilar)
    File("$klasorYolu\\T.txt").writeText(tekSayilar)
}


fun fun4(dosyaYolu: String) {
    val icerik = File(dosyaYolu).readText().toLowerCase()

    val satirSayisi = icerik.split("\n").size
    val kelimeSayisi = icerik.split(Regex("\\s+")).filter { it.isNotEmpty() }.size
    val sesliHarfler = listOf('a', 'e', 'i', 'o', 'u', 'ö', 'ü')
    val sesliSayisi = icerik.filter { it in sesliHarfler }.count()
    val sessizSayisi = icerik.filter { it.isLetter() && it !in sesliHarfler }.count()

    println("Dosya içerisinde:")
    println("Satır Sayısı: $satirSayisi")
    println("Kelime Sayısı: $kelimeSayisi")
    println("Sesli Harf Sayısı: $sesliSayisi")
    println("Sessiz Harf Sayısı: $sessizSayisi")
}

fun fun5(kaynakDosyaYolu: String, hedefDosyaYolu: String) {
    val icerik = File(kaynakDosyaYolu).readText()
    val tersIcerik = icerik.reversed()
    File(hedefDosyaYolu).writeText(tersIcerik)
}

fun fun6(kaynakDosyaYolu: String, hedefDosyaYolu: String) {
    val icerik = File(kaynakDosyaYolu).readText()
    val tersKelimeler = icerik.split(Regex("\\s+")).joinToString(" ") { it.reversed() }
    File(hedefDosyaYolu).writeText(tersKelimeler)
}


fun fun7(dosyaYolu: String) {
    val icerik = File(dosyaYolu).readText()
    val kelimeler = icerik.split(Regex("\\s+")).filter { it.isNotEmpty() }

    val kelimeFrekansi = mutableMapOf<String, Int>()
    var enUzunKelime = kelimeler[0]
    var enKisaKelime = kelimeler[0]

    for (kelime in kelimeler) {
        kelimeFrekansi[kelime] = kelimeFrekansi.getOrDefault(kelime, 0) + 1

        if (kelime.length > enUzunKelime.length) {
            enUzunKelime = kelime
        }

        if (kelime.length < enKisaKelime.length) {
            enKisaKelime = kelime
        }
    }

    println("Kelime Frekansları:")
    for ((kelime, frekans) in kelimeFrekansi) {
        println("$kelime: $frekans kez")
    }

    println("\nEn Uzun Kelime: \"$enUzunKelime\" - ${enUzunKelime.length} harf")
    println("En Kısa Kelime: \"$enKisaKelime\" - ${enKisaKelime.length} harf")
}

fun fun8(dizinYolu: String): Long {
    val dosya = File(dizinYolu)
    if (dosya.isFile) {
        return dosya.length()
    }

    var toplamBoyut = 0L
    dosya.listFiles()?.forEach { altDosya ->
        toplamBoyut += fun8(altDosya.absolutePath)
    }

    return toplamBoyut
}

data class DosyaBilgisi(val ad: String, val klasor: String, val boyut: Long)

fun fun9(dizinYolu: String, arananKelime: String): List<DosyaBilgisi> {
    val dosya = File(dizinYolu)
    val sonucListesi = mutableListOf<DosyaBilgisi>()

    if (dosya.isFile && dosya.name.contains(arananKelime)) {
        sonucListesi.add(DosyaBilgisi(dosya.name, dosya.parent, dosya.length()))
    } else if (dosya.isDirectory) {
        dosya.listFiles()?.forEach { altDosya ->
            sonucListesi.addAll(fun9(altDosya.absolutePath, arananKelime))
        }
    }

    return sonucListesi
}

/* hocam  soru 10 da  anlamadığım bir hata aldıgım için  çözemedim. Soğuk algınlıgım düzeldiginde

arkadaşlar ile discord üzerinden  yardım alıp çözmeye çalışıcam.*/





fun main() {
    val dosyaYolu = "C:\\Users\\yittu\\OneDrive\\Resimler\\Yeni Metin Belgesi (11).txt"
    val sonuclar = fun1(dosyaYolu)

    println("Dosyada bulunan sayıların özellikleri:")
    println("Pozitif Sayı: ${sonuclar.pozitif}")
    println("Negatif Sayı: ${sonuclar.negatif}")
    println("Tek Sayı: ${sonuclar.tek}")
    println("Çift Sayı: ${sonuclar.cift}")

    // val dosyaYolu = "C:\Users\yittu\OneDrive\Masaüstü\dump.txt.txt"

    // Dosyayı rastgele sayılarla doldur
    fun2(dosyaYolu)

    println("$dosyaYolu dosyası rastgele sayılarla dolduruldu!")

    fun3(dosyaYolu)

    println("Çift sayılar C.txt dosyasına, tek sayılar T.txt dosyasına yazıldı!")


    val dumpDosyaYolu = "C:\\Users\\yittu\\OneDrive\\Masaüstü\\dump.txt"

    // Dosyayı analiz et
    fun4(dumpDosyaYolu)

    //val dumpDosyaYolu = "C:\\Users\\yittu\\Desktop\\dump.txt"
    val tersDumpDosyaYolu = "C:\\Users\\yittu\\OneDrive\\Masaüstü\\dump_rev_1.txt"

    // Dosyanın içeriğini ters çevirip yeni bir dosyaya yaz
    fun5(dumpDosyaYolu, tersDumpDosyaYolu)

    println("Dosya içeriği ters çevrilerek dump_rev_1.txt dosyasına yazıldı!")

    //val dumpDosyaYolu = "C:\\Users\\yittu\\Desktop\\dump.txt"
    val tersDumpDosyaYolu2 = "C:\\Users\\yittu\\OneDrive\\Masaüstü\\dump_rev_2.txt"

    // Dosyanın içindeki kelimeleri ters çevirip yeni bir dosyaya yaz
    fun6(dumpDosyaYolu, tersDumpDosyaYolu2)

    println("Dosya kelimeleri ters çevrilerek dump_rev_2.txt dosyasına yazıldı!")

    fun7(dumpDosyaYolu)

    val scanner = Scanner(System.`in`)
    println("Lütfen klasör yolunu girin:")
    val klasorYolu = scanner.nextLine()

    val toplamBoyut = fun8(klasorYolu)
    println("Belirtilen klasörün toplam boyutu: $toplamBoyut bayt")


    val tarama = Scanner(System.`in`)
    println("Lütfen aramak istediğiniz kelimeyi girin:")
    val kelime = tarama.nextLine()

    println("Lütfen başlangıç klasorunYolu girin:")
    val klasorunYolu = tarama.nextLine()

    val sonuclarimiz = fun9(klasorunYolu, kelime)

    println("\nToplam ${sonuclarimiz.size} dosya bulundu.")
    sonuclarimiz.forEach {
        println("Dosya Adı: ${it.ad}")
        println("Bulunduğu Klasör: ${it.klasor}")
        println("Boyutu: ${it.boyut} bayt\n")



    }


}

package com.example.kotlin_day1._odevler_

import java.io.File
import kotlin.random.Random

fun main(args: Array<String>) {

    soru1("C:\\Users\\regen\\Documents\\sayilar.txt")

    soru2("C:\\Users\\regen\\Documents\\sayilar.txt")

    soru3("C:\\Users\\regen\\Documents\\sayilar.txt")

    soru4("C:\\Users\\regen\\Documents\\dump.txt")

    soru5("C:\\Users\\regen\\Documents\\dump.txt")

    soru6("C:\\Users\\regen\\Documents\\dump.txt")

    soru7("C:\\Users\\regen\\Documents\\dump.txt")

    soru8("C:\\Users\\regen\\Documents")

    soru9("C:\\Users\\regen\\Documents", "Ipsum")

    soru10("C:\\Users\\regen\\Documents", "Lorem ")

}

fun soru1(dosyaAdi: String) {
    val dosya = File(dosyaAdi)

    val pozitifSayisi =
        dosya.readLines().count { sayi -> sayi.toIntOrNull()?.let { it > 0 } ?: false }
    val negatifSayisi =
        dosya.readLines().count { sayi -> sayi.toIntOrNull()?.let { it < 0 } ?: false }
    val ciftSayisi =
        dosya.readLines().count { sayi -> sayi.toIntOrNull()?.let { it % 2 == 0 } ?: false }
    val tekSayisi =
        dosya.readLines().count { sayi -> sayi.toIntOrNull()?.let { it % 2 != 0 } ?: false }

    println("Dosyada Kaç Tane:")
    println("Pozitif Sayı: $pozitifSayisi")
    println("Negatif Sayı: $negatifSayisi")
    println("Tek Sayı: $tekSayisi")
    println("Çift Sayı: $ciftSayisi")
}

fun soru2(dosyaAdi: String) {
    val dosya = File(dosyaAdi)

    dosya.bufferedWriter().use { writer ->
        repeat(500) {
            val sayi = (Math.random() * 2000) - 1000
            writer.write("$sayi\n")
        }
    }

    println("$dosyaAdi adlı dosya rastgele sayılarla dolduruldu.")
}

fun soru3(dosyaAdi: String) {
    val dosya = File(dosyaAdi)

    val cDosyasi = File(dosyaAdi.replace(".txt", "_c.txt"))
    val tDosyasi = File(dosyaAdi.replace(".txt", "_t.txt"))

    dosya.forEachLine { satir ->
        val sayi = satir.toIntOrNull()
        if (sayi != null) {
            if (sayi % 2 == 0) {
                cDosyasi.appendText("$sayi\n")
            } else {
                tDosyasi.appendText("$sayi\n")
            }
        }
    }

    println("C.txt ve T.txt dosyaları oluşturuldu.")
}

fun soru4(dosyaAdi: String) {
    val dosya = File(dosyaAdi)

    val satirSayisi = dosya.readLines().size
    val kelimeSayisi = dosya.readText().split(Regex("\\s+")).size
    val sessizHarfSayisi = dosya.readText().count { it in "bcdfghjklmnpqrstvwxyz" }
    val sesliHarfSayisi = dosya.readText().count { it in "aeıioöuüAEIİOÖUÜ" }

    println("Dosyada Kaç Satır: $satirSayisi")
    println("Dosyada Kaç Kelime: $kelimeSayisi")
    println("Sessiz Harf Sayısı: $sessizHarfSayisi")
    println("Sesli Harf Sayısı: $sesliHarfSayisi")
}

fun soru5(dosyaAdi: String) {
    val dosya = File(dosyaAdi)
    val dosyaRev = File("dump_rev_1.txt")

    val tersIcerik = dosya.readText().reversed()
    dosyaRev.writeText(tersIcerik)

    println("dump_rev_1.txt dosyasına ters çevrilmiş içerik yazıldı.")
}

fun soru6(dosyaAdi: String) {
    val dosya = File(dosyaAdi)
    val dosyaRev = File("dump_rev_2.txt")

    val kelimeler = dosya.readText().split(Regex("\\s+"))
    val tersKelimeler = kelimeler.reversed().joinToString(separator = " ")

    dosyaRev.writeText(tersKelimeler)
}

fun soru7(dosyaAdi: String) {
    val dosya = File(dosyaAdi)

    val kelimeler = dosya.readText().split(Regex("\\s+"))
    val kelimeFrekans = kelimeler.groupingBy { it }.eachCount()

    println("Her Kelimeden Kaç Kez Geçtiği:")
    for ((kelime, frekans) in kelimeFrekans) {
        println("$kelime: $frekans kez")
    }

    val enUzunKelime = kelimeler.maxByOrNull { it.length }
    val enKisaKelime = kelimeler.minByOrNull { it.length }

    println("En Uzun Kelime: $enUzunKelime (Harf Sayısı: ${enUzunKelime?.length ?: 0})")
    println("En Kısa Kelime: $enKisaKelime (Harf Sayısı: ${enKisaKelime?.length ?: 0})")
}

fun soru8(klasorYolu: String) {
    val klasor = File(klasorYolu)

    val toplamBoyut = klasor.listFiles()?.sumOf { it.length() } ?: 0L

    println("Toplam Boyut: $toplamBoyut byte")
}

fun soru9(klasorYolu: String, kelime: String) {
    val klasor = File(klasorYolu)
    val sonuc = klasor.listFiles()?.mapNotNull { dosya ->
        val icerik = dosya.readText()
        if (kelime in icerik) {
            Triple(dosya.name, dosya.length(), dosya.parent)
        } else {
            null
        }
    } ?: emptyList()

    println("Arama Sonucu: ${sonuc.size} dosya bulundu")
    for ((dosyaAdi, dosyaBoyutu, klasorAdi) in sonuc) {
        println("Dosya Adı: $dosyaAdi")
        println("Bulunduğu Klasör: $klasorAdi")
        println("Boyut: $dosyaBoyutu byte")
    }
}

fun soru10(klasorYolu: String, kelime: String) {
    val klasor = File(klasorYolu)
    val sonuc = klasor.listFiles()?.filter { dosya ->
        val icerik = dosya.readText()
        icerik.contains(kelime)
    } ?: emptyList()

    println("Arama Sonucu: ${sonuc.size} dosya bulundu")
    for (dosya in sonuc) {
        println("Dosya Adı: ${dosya.name}")
        println("Bulunduğu Klasör: ${dosya.parent}")
        println("Boyut: ${dosya.length()} byte")
    }
}








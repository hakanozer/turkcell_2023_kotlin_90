package com.tutkuzdmr.a3odev.Sorular

import java.io.File
import java.util.regex.Pattern

fun main(args: Array<String>) {

    val dosyaYolu = "C:\\Users\\tutku\\OneDrive\\Masaüstü\\dump.txt"
    val dosya = File(dosyaYolu)



    if (dosya.exists()) {
        val satirlar = dosya.readLines()
        val kelimeSayisi = hesaplaKelimeSayisi(satirlar)
        val sessizHarfSayisi = hesaplaSessizHarfSayisi(satirlar)
        val sesliHarfSayisi = hesaplaSesliHarfSayisi(satirlar)


        println("Dosyada toplam ${satirlar.size} satır bulunmaktadır.")
        println("Dosyada toplam $kelimeSayisi kelime bulunmaktadır.")
        println("Dosyada toplam $sessizHarfSayisi sessiz harf bulunmaktadır.")
        println("Dosyada toplam $sesliHarfSayisi sesli harf bulunmaktadır.")
    } else {
        println("Dosya bulunamadı.")
    }
}

fun hesaplaKelimeSayisi(satirlar: List<String>): Int {
    val kelimeDeseni = Pattern.compile("\\b\\w+\\b")
    var toplamKelime = 0

    for (satir in satirlar) {
        val eslesmeler = kelimeDeseni.matcher(satir)
        while (eslesmeler.find()) {
            toplamKelime++
        }
    }

    return toplamKelime
}

fun hesaplaSessizHarfSayisi(satirlar: List<String>): Int {
    val sessizHarfDeseni = Pattern.compile("[bçdfghjklmnpqrstvwxyzBÇDFGHJKLMNPQRSTVWXYZ]")
    var toplamSessizHarf = 0

    for (satir in satirlar) {
        val eslesmeler = sessizHarfDeseni.matcher(satir)
        while (eslesmeler.find()) {
            toplamSessizHarf++
        }
    }

    return toplamSessizHarf
}

fun hesaplaSesliHarfSayisi(satirlar: List<String>): Int {
    val sesliHarfDeseni = Pattern.compile("[aeiouAEIOU]")
    var toplamSesliHarf = 0

    for (satir in satirlar) {
        val eslesmeler = sesliHarfDeseni.matcher(satir)
        while (eslesmeler.find()) {
            toplamSesliHarf++
        }
    }

    return toplamSesliHarf
}
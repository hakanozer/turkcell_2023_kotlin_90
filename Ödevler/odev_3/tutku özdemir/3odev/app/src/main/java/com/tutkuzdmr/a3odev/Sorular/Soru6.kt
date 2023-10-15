package com.tutkuzdmr.a3odev.Sorular

import java.io.File
import java.util.regex.Pattern

fun main(args: Array<String>) {

    val dosyaYolu = "CC:\\Users\\tutku\\OneDrive\\Masaüstü\\dump.txt"
    val dosya = File(dosyaYolu)

    if (dosya.exists()) {
        val satirlar = dosya.readLines()
        val kelimeler = satirlar.joinToString(" ").split("\\s+".toRegex())

        val kelimeSayilari = hashMapOf<String, Int>()
        var enUzunKelime = ""
        var enKisaKelime = kelimeler.first()

        for (kelime in kelimeler) {
            kelimeSayilari[kelime] = kelimeSayilari.getOrDefault(kelime, 0) + 1

            if (kelime.length > enUzunKelime.length) {
                enUzunKelime = kelime
            }

            if (kelime.length < enKisaKelime.length) {
                enKisaKelime = kelime
            }
        }

        println("Her kelimenin geçiş sayısı:")


        for ((kelime, sayi) in kelimeSayilari) {

            println("$kelime: $sayi")
        }

        println("En uzun kelime: $enUzunKelime, Harf sayısı: ${enUzunKelime.length}")
        println("En kısa kelime: $enKisaKelime, Harf sayısı: ${enKisaKelime.length}")

    } else {

        println("Dosya bulunamadı.")
    }
}
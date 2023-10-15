package com.tutkuzdmr.a3odev.Sorular

import java.io.File
import java.io.FileWriter

fun main(args: Array<String>) {
    val dosyaYolu = "C:\\Users\\tutku\\OneDrive\\Masaüstü\\dump.txt"
    val hedefDosyaYolu = "C:\\Users\\tutku\\OneDrive\\Masaüstü\\dump_rev_2.txt"

    val dosya = File(dosyaYolu)

    try {
        val satir = dosya.readLines()
        val terstenYazdir = satir.map { kelimeTerstenYaz(it) }.joinToString("\n")

        val hedefDosya = File(hedefDosyaYolu)
        hedefDosya.writeText(terstenYazdir)

        println("Dosya kelime sirasini bozmadan tersten yazdirildi.")

    } catch (ex: Exception) {

        println("Dosya işleme hatası: ${ex.message}")
    }
}

fun kelimeTerstenYaz(kelime: String): String {
    val kelimeler = kelime.split(" ")
    val tersKelimeler = kelimeler.map { it.reversed() }
    return tersKelimeler.joinToString(" ")
}
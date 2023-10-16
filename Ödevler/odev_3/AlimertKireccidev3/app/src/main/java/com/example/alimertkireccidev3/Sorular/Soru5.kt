package com.example.alimertkireccidev3.Sorular

import java.io.File

fun main(args: Array<String>) {
     val Dosyanınuzantısı = "C:\\Users\\Barbaros\\Documents\\NotePad++\\dump.txt"
    val hedefDosyaYolu = "C:\\Users\\Barbaros\\Documents\\NotePad++\\dump_rev_1.txt"
    val Dosyakaynagi = File(Dosyanınuzantısı)
    if (!Dosyakaynagi.exists()) {
        println("$Dosyanınuzantısı Dosyanın Adresinde Hata Mevcut!!.")
        return
    }
    val icindebulunan = Dosyakaynagi.readText()
    val Terstenyazdır = icindebulunan.reversed()
    val hedefDosya = File(hedefDosyaYolu)
    hedefDosya.writeText(Terstenyazdır)
    println("Dosya tersine çevrildi ==. $hedefDosyaYolu")
}
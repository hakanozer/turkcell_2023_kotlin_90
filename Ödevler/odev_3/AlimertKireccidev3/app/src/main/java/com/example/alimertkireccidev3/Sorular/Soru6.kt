package com.example.alimertkireccidev3.Sorular

import java.io.File

fun main(args: Array<String>) {
        val Dosyanınuzantısı = "C:\\Users\\Barbaros\\Documents\\NotePad++\\dump.txt"
        val hedefDosyaYolu = "C:\\Users\\Barbaros\\Documents\\NotePad++\\dump_rev_2.txt"
        val Dosyakaynagi = File(Dosyanınuzantısı)
        if (!Dosyakaynagi.exists()) {
            println("$Dosyanınuzantısı dosyası bulunamadı.")
            return
        }
        val kaynakIcerik = Dosyakaynagi.readText()
                val kelimeler = kaynakIcerik.split(Regex("\\s+"))
        val tersKelimeler = kelimeler.map { it.reversed() }
        val tersIcerik = tersKelimeler.joinToString(" ")
        val hedefDosya = File(hedefDosyaYolu)
        hedefDosya.writeText(tersIcerik)
        println("kelimelerin yerlerini Değiştirmeden Tersten yazdırma işlemi tamamlandı== $hedefDosyaYolu")

}
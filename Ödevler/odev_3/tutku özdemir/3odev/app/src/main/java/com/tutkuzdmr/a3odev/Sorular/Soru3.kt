package com.tutkuzdmr.a3odev.Sorular

import java.io.File
import java.io.FileWriter

fun main(args: Array<String>) {
    val dosyaYolu = "C:\\Users\\tutku\\OneDrive\\Masaüstü\\note.txt"
    val dosya = File(dosyaYolu)

    val ciftDosyaYolu = "C:\\Users\\tutku\\OneDrive\\Masaüstü\\C.txt"
    val tekDosyaYolu = "C:\\Users\\tutku\\OneDrive\\Masaüstü\\T.txt"

    try {
        val okuyucu = dosya.bufferedReader()
        val ciftYazici = FileWriter(ciftDosyaYolu)
        val tekYazici = FileWriter(tekDosyaYolu)

        var satir: String?
        while (okuyucu.readLine().also { satir = it } != null) {
            val sayi = satir!!.toInt()
            if (sayi % 2 == 0) {
                ciftYazici.write("$sayi\n")
            } else {
                tekYazici.write("$sayi\n")
            }
        }

        okuyucu.close()
        ciftYazici.close()
        tekYazici.close()

        println("cift ve tek sayilar dosyalara yazildi.")
    } catch (ex: Exception) {
        println("Dosya okuma ve yazma hatasi: ${ex.message}")
    }
}
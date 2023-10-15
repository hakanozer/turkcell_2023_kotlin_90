package com.tutkuzdmr.a3odev.Sorular

import java.io.File

fun main(args: Array<String>) {

    val dosyaYolu = "C:\\Users\\tutku\\OneDrive\\Masaüstü\\note.txt"
    var pozitif = 0
    var negatif = 0
    var cift = 0
    var tek = 0
    val dosya = File(dosyaYolu)

    try {
        val read = dosya.readLines()

        for (satir in read) {
            val sayi = satir.toInt()
            if (sayi > 0) pozitif++
            if (sayi < 0) negatif++
            if (sayi % 2 == 0) cift++
            else tek++
        }

        println("Dosyada $pozitif pozitif sayi, $negatif negatif sayi, $tek tek sayi, $cift cift sayi bulunmaktadir.")
    } catch (ex: Exception) {
        println("Dosya okuma hatası: ${ex.message}")
    }
}
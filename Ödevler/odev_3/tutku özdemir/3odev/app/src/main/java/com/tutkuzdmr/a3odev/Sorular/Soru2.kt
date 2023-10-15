package com.tutkuzdmr.a3odev.Sorular

import java.io.File
import java.io.FileWriter
import java.util.Random

fun main(args: Array<String>) {
    val dosyaYolu = "C:\\Users\\tutku\\OneDrive\\Masaüstü\\note.txt"
    val dosya = File(dosyaYolu)


    try {
        val writer = FileWriter(dosya)
        val random = Random()

        for (i in 1..500) {

            val sayi = random.nextInt(2001) - 1000
            writer.write("$sayi\n")
        }

        writer.close()

        println("Dosya olusturuldu.")
    }
    catch (ex: Exception) {

        println("Dosya olusturma ve doldurma hatasi: ${ex.message}")
    }
}
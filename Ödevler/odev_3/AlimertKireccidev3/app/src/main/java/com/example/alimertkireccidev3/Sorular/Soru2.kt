package com.example.alimertkireccidev3.Sorular

import java.io.File
import kotlin.random.Random


fun main(args: Array<String>) {
    // Dosyanın adını ve yolunu belirtin
    val dosyaYolu = "C:\\Users\\Barbaros\\Documents\\NotePad++\\yeni_1.txt"
    val dosya = File(dosyaYolu)
    dosya.bufferedWriter().use { writer ->
        repeat(500) {
            val rastgeleSayi = Random.nextInt(-1000, 1000)
            writer.write("$rastgeleSayi\n")
        }
    }

    println("-1000 ile 1000 arasında dosya oluşturuldu= : $dosyaYolu")
}
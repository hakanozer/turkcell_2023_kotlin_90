package com.nazlican.turkcellgelecegiyazanlarhomework3

//İçindeki dump.txt Dosyasını
//Masaüstüne Çıkartın.
//
//Uygulamaya Bu Dosyayı Okuttuğunuz Zaman,
//Bu Dosyada Kaç Satır, Kaç Kelime Var,
//Harflerin Kaçı Sessiz, Kaçı Sesli Bu Bilgileri Konsola Yazan Bir Uygulama Yazın

import java.io.File

fun main() {
    val dumpFilePath = "C:\\Users\\nazli\\OneDrive\\Masaüstü\\TurkcellGelecegiYazanlarHomework3\\random_numbers.txt"

    try {
        val fileResponse = File(dumpFilePath).readText()
        val lineCount = fileResponse.lines().size
        var vowelCount = 0
        var consonantCount = 0
        val words = fileResponse.split(" ").filter { it.isNotBlank() }

        words.forEach { word ->
            word.toLowerCase().forEach { char ->
                if (char.isLetter()) {
                    if (char in "aeiou") {
                        vowelCount++
                    } else {
                        consonantCount++
                    }
                }
            }
        }

        println("Satır Sayısı: $lineCount")
        println("Kelime Sayısı: ${words.size}")
        println("Sesli Harf Sayısı: $vowelCount")
        println("Sessiz Harf Sayısı: $consonantCount")

    } catch (e: Exception) {
        println("Dosya okuma hatası: ${e.message}")
    }
}
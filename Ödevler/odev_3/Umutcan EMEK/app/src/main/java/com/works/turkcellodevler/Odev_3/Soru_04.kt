package com.works.turkcellodevler.Odev_3

import java.io.File

/*
#4. İçindeki dump.txt Dosyasını
Masaüstüne Çıkartın.

Uygulamaya Bu Dosyayı Okuttuğunuz Zaman,
Bu Dosyada Kaç Satır, Kaç Kelime Var,
Harflerin Kaçı Sessiz, Kaçı Sesli Bu Bilgileri Konsola Yazan Bir Uygulama Yazın
 */

fun main(args: Array<String>) {

    val file = File("C:\\Users\\umutc\\Desktop\\dump.txt")
    val scope = file.readText()

    val numbOfLines = scope.lines().size
    val words = scope.split(Regex("\\s+"))
    val wordCount = words.size

    var numOfConsonants = 0
    var numOfvowels = 0

    for (char in scope) {
        val charLetter = char.toLowerCase()
        if (charLetter.isLetter()) {
            if (charLetter in "bcçdfgğhjklmnprsştvyz") {
                numOfConsonants++
            } else if (charLetter in "aeiouıüö") {
                numOfvowels++
            }
        }
    }
    println("Dosyada bulunan satır sayısı:  $numbOfLines")
    println("Dosyada bulunan kelime sayısı:  $wordCount")
    println("Dosyada bulunan sessiz harf sayısı:  $numOfConsonants")
    println("Dosyada bulunan sesli harf sayısı:  $numOfvowels")

}

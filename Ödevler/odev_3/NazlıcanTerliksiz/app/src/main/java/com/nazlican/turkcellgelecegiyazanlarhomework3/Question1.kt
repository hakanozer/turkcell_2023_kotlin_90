package com.nazlican.turkcellgelecegiyazanlarhomework3

//Notepad++ İle Bir Dosya Oluşturun
//İçine 15 Tane Sayı Yazın (Arada Pozitif, Negatif Sayılarda Olsun)
//
//Uygulamanıza Bu Dosyanın Yolunu Vereceksiniz.Uygulamanız Ekrana
//Dosyada Kaç Tane :
//- Pozitif
//- Negatif
//- Tek
//- Çift Sayı Olduğunu Bastıracak.

import java.io.File

fun main(args: Array<String>) {
    val filePath = "C:\\Users\\nazli\\OneDrive\\Masaüstü\\TurkcellGelecegiYazanlarHomework3\\random_numbers.txt"
    try {
        val file = File(filePath)
        val data = file.readLines()

        val counts = getCounts(data)
        printCounts(counts)

    } catch (ex: Exception) {
        println("Dosya Bulunamadi.")
    }
}

fun getCounts(data: List<String>): Array<Int> {
    var positiveNumber = 0
    var negativeNumber = 0
    var evenNumber = 0
    var oddNumber = 0

    for (item in data) {
        val number = item.toInt()
        if (number >= 0) {
            positiveNumber++
        }
        if (number < 0) {
            negativeNumber++
        }
        if (number % 2 == 0) {
            evenNumber++
        } else
            oddNumber++
    }

    return arrayOf(positiveNumber, negativeNumber, evenNumber, oddNumber)
}

fun printCounts(counts: Array<Int>) {
    println("Pozitif ${counts[0]}")
    println("Negatif ${counts[1]}")
    println("Cift ${counts[2]}")
    println("Tek ${counts[3]}")
}





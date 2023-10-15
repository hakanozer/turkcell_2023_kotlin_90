package com.nazlican.turkcellgelecegiyazanlarhomework3

//2. Soruda Oluşturduğunuz Dosyayı Açıp Okuyan, Input Dosyasının Bulunduğu Klasore
//C.txt Adında Bir Dosya Oluşturup, Input Dosyasının İçindeki Cift Sayıları Yazan,
//T.txt Adında Bir Dosya Olusturup, Tek Sayıları Yazan Bir Uygulama Yazın

import java.io.File

fun main() {
    val filePath = "C:\\Users\\nazli\\OneDrive\\Masaüstü\\TurkcellGelecegiYazanlarHomework3\\random_numbers.txt"
    val numbers = File(filePath).readLines().map { it.toInt() }
    val (evenNumbers, oddNumbers) = numbers.partition { it % 2 == 0 }

    val evenFilePath = "C:\\Users\\nazli\\OneDrive\\Masaüstü\\TurkcellGelecegiYazanlarHomework3\\random_numbers.txt"
    val oddFilePath = "C:\\Users\\nazli\\OneDrive\\Masaüstü\\TurkcellGelecegiYazanlarHomework3\\random_numbers.txt"

    File(evenFilePath).printWriter().use { out ->
        evenNumbers.forEach { out.println(it) }
    }

    File(oddFilePath).printWriter().use { out ->
        oddNumbers.forEach { out.println(it) }
    }
}
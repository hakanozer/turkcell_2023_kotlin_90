package com.nazlican.turkcellgelecegiyazanlarhomework3

//#2. 1. Sorudaki Dosyayı -1000, +1000 Arası 500 Tane Random Sayıyla Dolduran Bir Uygulama Yazın.

import java.io.File
import kotlin.random.Random

fun main() {
    val filePath = "C:\\Users\\nazli\\OneDrive\\Masaüstü\\TurkcellGelecegiYazanlarHomework3\\random_numbers.txt"
    val numbers = arrayListOf<String>()
    for (i in 1..500) {
        val randomNumber = Random.nextInt(-1000, 1001)
        numbers.add(randomNumber.toString())
    }
    writeFile(filePath, numbers)
}

fun writeFile(filePath: String, numbers: List<String>) {
    val file = File(filePath)
    file.bufferedWriter().use { writer ->
        numbers.forEach { number ->
            writer.write("$number\n")
        }
    }
}
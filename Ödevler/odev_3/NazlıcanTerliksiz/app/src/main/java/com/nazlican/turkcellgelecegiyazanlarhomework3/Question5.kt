package com.nazlican.turkcellgelecegiyazanlarhomework3

//4. Sorudaki dump.txt yi, dump_rev_1.txt Dosyasına Tersten Yazdırın

import java.io.File

fun main() {
    val inputFilePath = "C:\\Users\\nazli\\OneDrive\\Masaüstü\\TurkcellGelecegiYazanlarHomework3\\random_numbers.txt"
    val inputFile = File(inputFilePath)
    val outputFilePath = "C:\\Users\\nazli\\OneDrive\\Masaüstü\\TurkcellGelecegiYazanlarHomework3\\random_numbers.txt"
    val outputFile = File(outputFilePath)

    try {
        val inputText = inputFile.readText().trimIndent()
        outputFile.writeText(inputText.reversed())
    } catch (e: Exception) {
        println(e.message)
    }
}
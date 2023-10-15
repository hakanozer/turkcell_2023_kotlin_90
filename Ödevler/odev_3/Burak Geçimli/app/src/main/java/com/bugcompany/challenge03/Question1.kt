package com.bugcompany.challenge03

import java.io.File
import java.io.FileNotFoundException

class Question1(fileName: String) {
    private var numberList: List<Int>

    init {
        try {
            val file = File(fileName)
            numberList = file.readLines().map { it.trim().toInt() }
        } catch (e: FileNotFoundException) {
            numberList = emptyList()
            println("Dosya bulunamadı.")
        } catch (e: NumberFormatException) {
            numberList = emptyList()
            println("Dosyadaki değerler sayısal değil.")
        }
    }

    fun countNumbers() {
        val positive = numberList.count { it > 0 }
        val negative = numberList.count { it < 0 }
        val odd = numberList.count { it % 2 != 0 }
        val even = numberList.count { it % 2 == 0 }

        println("Dosyada $positive tane pozitif sayı var.")
        println("Dosyada $negative tane negatif sayı var.")
        println("Dosyada $odd tane tek sayı var.")
        println("Dosyada $even tane çift sayı var.")
    }

}
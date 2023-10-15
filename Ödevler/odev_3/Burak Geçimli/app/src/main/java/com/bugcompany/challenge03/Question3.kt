package com.bugcompany.challenge03

import java.io.File
import java.io.FileWriter
import java.io.IOException

class Question3 {

    fun createOddEvenFile(fileName: String) {
        val file = File(fileName)
        val numbers = file.readLines().map { it.trim().toInt() }

        val evenNumbers = numbers.filter { it % 2 == 0 }
        val oddNumbers = numbers.filter { it % 2 != 0 }

        // C.txt adında bir dosya oluştur ve çift sayıları yaz
        File("C.txt").writeText(evenNumbers.joinToString(" "))

        // T.txt adında bir dosya oluştur ve tek sayıları yaz
        File("T.txt").writeText(oddNumbers.joinToString(" "))
    }
}


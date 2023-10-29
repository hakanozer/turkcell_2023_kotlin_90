package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru1 {
    fun selectRandomNumbers() {
        val numbers = List(6) { (1..49).random() }.toMutableSet()

        while (numbers.size < 6) {
            numbers += (1..49).random()
        }
        println("Secilen sayilar: ${numbers.sorted().joinToString(", ")}")
    }
}
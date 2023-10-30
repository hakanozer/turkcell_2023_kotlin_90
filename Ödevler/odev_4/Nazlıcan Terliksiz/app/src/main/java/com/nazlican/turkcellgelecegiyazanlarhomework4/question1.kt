package com.nazlican.turkcellgelecegiyazanlarhomework4

import kotlin.random.Random

fun main() {
    val selectedNumbers = mutableSetOf<Int>()

    while (selectedNumbers.size < 6) {
        val randomNumber = Random.nextInt(1, 50)
        if (!selectedNumbers.contains(randomNumber)) {
            selectedNumbers.add(randomNumber)
        }
    }

    println("Seçilen sayılar: ")
    for (number in selectedNumbers) {
        println(number)
    }
}
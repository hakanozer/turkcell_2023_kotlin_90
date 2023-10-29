package com.works.homework4

import kotlin.random.Random

class Soru1 {
    class RandomNumberGenerator {
        fun generateRandomNumbers(): List<Int> {
            val numbers = mutableListOf<Int>()

            while (numbers.size < 6) {
                val randomNum = Random.nextInt(1, 50)
                if (!numbers.contains(randomNum)) {
                    numbers.add(randomNum)
                }
            }

            return numbers
        }
    }
}


fun main() {
    val numberGenerator = Soru1.RandomNumberGenerator()
    val randomNumbers = numberGenerator.generateRandomNumbers()

    println("Soru1- Rastgele seçilen 6 farklı sayı:")
    for (number in randomNumbers) {
        println(number)
    }
}
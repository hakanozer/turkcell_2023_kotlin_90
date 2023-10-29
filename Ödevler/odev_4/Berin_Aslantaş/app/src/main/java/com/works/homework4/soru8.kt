package com.works.homework4


class Soru8 {
    fun calculatePositiveSum(numbers: List<Int>): Int {
        return numbers.filter { it > 0 }.sum()
    }
}


fun main() {
    val numbers = listOf(-3, -2, 0, 4, 5, 8, 10, 11)

    val calculator = Soru8()
    val positiveSum = calculator.calculatePositiveSum(numbers)

    println("Pozitif sayıların toplamı: $positiveSum")
}

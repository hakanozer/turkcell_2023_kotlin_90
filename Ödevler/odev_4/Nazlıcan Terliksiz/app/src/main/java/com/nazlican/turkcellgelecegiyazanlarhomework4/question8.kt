package com.nazlican.turkcellgelecegiyazanlarhomework4

fun sumOfPositiveNumbers(list: List<Int>): Int {
    var sum = 0
    for (number in list) {
        if (number > 0) {
            sum += number
        }
    }
    return sum
}

fun main() {
    val myList = listOf(3, -2, 5, -8, 10, -4, 6, -1, 7, -3)
    val totalSum = sumOfPositiveNumbers(myList)
    println("Listedeki pozitif sayıların toplamı: $totalSum")
}
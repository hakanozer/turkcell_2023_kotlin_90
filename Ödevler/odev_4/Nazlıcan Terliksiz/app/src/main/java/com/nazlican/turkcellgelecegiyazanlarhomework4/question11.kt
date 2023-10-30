package com.nazlican.turkcellgelecegiyazanlarhomework4

fun sortDescending(numbers: List<Int>): List<Int> {
    return numbers.sortedDescending()
}

fun main() {
    val list = listOf(23, 15, 37, 7, 41, 29, 14, 55, 28, 19)

    val sortedList = sortDescending(list)
    println("Sıralanmış Liste:")
    sortedList.forEach { println(it) }
}
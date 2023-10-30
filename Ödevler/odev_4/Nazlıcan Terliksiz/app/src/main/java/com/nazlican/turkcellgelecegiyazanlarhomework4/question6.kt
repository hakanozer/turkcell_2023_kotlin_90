package com.nazlican.turkcellgelecegiyazanlarhomework4

fun countOccurrence(list: List<Int>, value: Int): Int {
    var count = 0
    for (item in list) {
        if (item == value) {
            count++
        }
    }
    return count
}

fun main() {
    val myList = listOf(1, 2, 3, 4, 2, 2, 3, 2, 5, 6, 2, 7, 8, 2, 9)
    val targetValue = 2

    val occurrenceCount = countOccurrence(myList, targetValue)
    println("$targetValue değeri listenin içinde $occurrenceCount kez tekrarlanıyor.")
}
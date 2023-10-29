package com.works.homework4


class Soru11 {
    fun sortRandomNumbers(numbers: List<Int>): List<Int> {
        return numbers.sortedDescending()
    }
}


fun main() {
    val rastgeleSayilar = listOf(4, 64, 3, 81, 16, 11)

    val listSorter = Soru11()
    val siraliSayilar = listSorter.sortRandomNumbers(rastgeleSayilar)

    println(" Büyükten küçüğe sıralanmış sayılar: $siraliSayilar")
}

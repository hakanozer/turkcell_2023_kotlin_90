package com.works.homework4


class Soru6 {
    fun countOccurrences(list: List<String>, target: String): Int {
        return list.count { it == target }
    }
}


fun main() {
    val myList = listOf("c", "u", "m", "h", "u", "r", "i", "y", "e", "t", "i", "n", "y", "ü", "z", "ü", "n", "c", "ü", "y", "ı", "l", "ı", "k", "u", "t", "l", "u", "o", "l", "s", "u", "n")
    val targetElement = "u"

    val listCounter = Soru6()
    val count = listCounter.countOccurrences(myList, targetElement)

    println("$targetElement harfi $count kez tekrarlandı.")
}

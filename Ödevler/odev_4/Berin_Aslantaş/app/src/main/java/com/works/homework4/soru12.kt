package com.works.homework4


class Soru12 {
    fun findCommonElements(set1: Set<String>, set2: Set<String>): Set<String> {
        return set1.intersect(set2)
    }
}


fun main() {
    val set1 = setOf("1", "9", "3", "5", "8", "6")
    val set2 = setOf("6", "8", "7", "9", "2", "3")

    val setComparator = Soru12 ()
    val commonElements = setComparator.findCommonElements(set1, set2)

    println("Ortak Elemanlar: $commonElements")
}

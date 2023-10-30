package com.tutkuzdmr.collectionodevi

fun main(args: Array<String>) {

    val set1 = setOf(1, 2, 3, 4, 5)
    val set2 = setOf(3, 4, 5, 6, 7)

    val ortak = set1.intersect(set2)

    println("Ortak Elemanlar: $ortak")
}
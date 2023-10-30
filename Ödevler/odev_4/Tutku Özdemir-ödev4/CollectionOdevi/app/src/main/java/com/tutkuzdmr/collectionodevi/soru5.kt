package com.tutkuzdmr.collectionodevi

fun main(args: Array<String>) {

    val set = setOf(1, 2, 3, 4, 5)
    val list = listOf(4, 2, 6, 7, 1)

    val birlesmis = set + list

    println("Birleştirilmiş Collection: $birlesmis")
}
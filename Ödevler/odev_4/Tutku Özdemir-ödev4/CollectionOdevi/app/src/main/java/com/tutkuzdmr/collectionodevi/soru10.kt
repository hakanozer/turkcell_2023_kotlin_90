package com.tutkuzdmr.collectionodevi

fun main(args: Array<String>) {

    val metinListesi = listOf("ada", "adam", "adama", "abi", "abim", "abime")

    val siraliMetinler = metinListesi.sortedBy { it.length }

    val enKisaMetin = siraliMetinler.first()
    val enUzunMetin = siraliMetinler.last()

    println("Metinlerin Sıralı Hali: $siraliMetinler")
    println("En Kısa Metin: $enKisaMetin")
    println("En Uzun Metin: $enUzunMetin")
}
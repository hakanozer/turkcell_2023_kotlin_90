package com.tutkuzdmr.collectionodevi

fun listeSırala(liste: List<Int>): List<Int> {
    return liste.sortedDescending()
}

fun main(args: Array<String>) {

    val Sayilar = listOf(42, 15, 7, 99, 23, 50, 88, 12, 34)

    val siralanmisListe = listeSırala(Sayilar)

    println("Sıralanmış Liste: $siralanmisListe")
}
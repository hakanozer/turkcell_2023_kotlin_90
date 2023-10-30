package com.works.odev.Ödev4

/**
 *12. İki Set'i karşılaştırarak, her iki Set'in de içinde bulunan ortak elemanları bulan bir Kotlin programı yazın.
 */
fun main(args: Array<String>) {
    val set1 = setOf<Int>(7,45,8,9,14,15,12,14)
    val set2 = setOf<Int>(7,8,14,111,25,9,7,14)

    val ortak = set1.intersect(set2)

    println("Ortak elemanlar : $ortak")
}
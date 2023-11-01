package com.works.turkcellodevler.Odev_4

/*
12. İki Set'i karşılaştırarak, her iki Set'in de içinde bulunan ortak elemanları bulan bir Kotlin programı yazın.
 */

fun main(args: Array<String>) {

    val set1 = setOf(1,2,3,4,5,6)
    val set2 = setOf(4,5,6,7,8,9)

    val intersection = mutableListOf<Int>()

    for (item in set1){
        if (item in set2){
            intersection.add(item)
        }
    }

    println("İki set karşılaştırıldığında ortak olan elamanlar: $intersection")

}
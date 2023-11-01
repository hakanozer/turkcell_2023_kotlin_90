package com.works.turkcellodevler.Odev_4

/*
10. İçinde metin içeren bir List oluşturun. Bu metinleri uzunluğuna göre sıralayarak en kısa ve en uzun metinleri bulun.
 */

fun main(args: Array<String>) {

    val list = listOf("Ali","Mehmet","Umutcan","Mert")
    val sorted = list.sortedBy { it.length }

    val shortest = sorted.first()
    val longest = sorted.last()

    println("Listedeki en kısa metin: $shortest")
    println("Listedeki en uzun metin: $longest")

}
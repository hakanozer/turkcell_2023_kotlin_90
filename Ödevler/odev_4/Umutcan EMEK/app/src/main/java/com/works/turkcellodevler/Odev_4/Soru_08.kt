package com.works.turkcellodevler.Odev_4

/*
8. Bir List'teki tüm elemanların toplamını hesaplayan bir Kotlin işlevi yazın. Ayrıca, bu işlevin
sadece pozitif sayıları dikkate almasını sağlayın.
 */

fun main(args: Array<String>) {

    val list = listOf(2,5,88,-5,2,-89,-2,14,2)

    var sum = 0
    for (item in list){
        if (item >= 0){
            sum += item
        }
    }

    println("Dizinin içindeki pozitif tam sayıların toplamı: $sum")

}
package com.works.turkcellodevler.Odev_4

/*
5. Bir Set ve bir List oluşturun. Set'teki benzersiz elemanları, List'teki sırayla bulunan elemanları
koruyarak birleştirin. Sonuçta nasıl bir koleksiyon elde edersiniz, bunu ekrana yazdırın.
 */

fun main(args: Array<String>) {

    val set = setOf(1,2,3,4,5,1)
    val list = listOf(3,4,5,6,7,6)

    val combinedList = mutableListOf<Int>()

    for (item in set){
        if (item !in combinedList){
            combinedList.add(item)
        }
    }

    for (item in list){
        combinedList.add(item)
    }

    println("Birleştirilmiş Liste: $combinedList")
}
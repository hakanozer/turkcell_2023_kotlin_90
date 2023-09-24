package com.works.turkcell._9_arrays

fun main(args: Array<String>) {

    // Array
    // 2 türü vardır
    // 1. UnMutable -> daha sonradan değişme ihtimali yok
    // 2. Mutable -> daha sonradan değişime açık. Item Ekle, silinme

    val cities = arrayOf("İstanbul", "Ankara", "Samsun", "Adana")
    println(cities[0])
    println(cities[2])

    val size = cities.size
    val index = 2
    println("size $size")
    if ( size > index ) {
        println(cities[index])
        // 0 -> index
    }

    // toplu işlemler
    for ( item in cities ) {
        println(item)
    }

    cities.set(2, "Antalya")
    println("=======================")
    for( i in 0..cities.size - 1 ) {
        val item = cities[i]
        println(item)
    }


    // Object Array
    val arr1 = arrayOf<Int>()
    val arr = arrayOf<User>()

}


package com.works.turkcell.hw2

/**
 * parametre olarak bir int[]ve bir sayi
 * alan, eğer array sayiyi içeriyorsa true,
 * içermiyorsa false döndüren bir method yazin
 */

fun main(args: Array<String>) {
     val contain = containArray(intArrayOf(8,7,0,1), 98)
    println("$contain")
}

fun containArray (array: IntArray,number: Int ): Boolean{
    var sonuc = false
    for (item in array){
        if (item == number){
            sonuc = true
            break
        }
    }
    return sonuc
}
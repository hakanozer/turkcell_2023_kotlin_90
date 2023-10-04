package com.works.odevler

/**
 * 9 - parametre olarak bir int[]ve bir sayi
 * alan, eğer array sayiyi içeriyorsa true,
 * içermiyorsa false döndüren bir method yazin
 */
fun main(args: Array<String>) {
    val dizi = intArrayOf(10,25,65,4,17,18)
    val degisken = 19
    val status = bool(dizi , degisken)
    println(status)

}

fun bool(arr: IntArray,sayi: Int): Boolean {
    for (item in arr){
        if(item == sayi){
           return true
        }
    }
    return false
}
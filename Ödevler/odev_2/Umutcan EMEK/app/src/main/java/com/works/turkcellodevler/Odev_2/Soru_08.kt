package com.works.turkcellodevler.Odev_2

/*
8 - parametre olarak verilen int[] deki
en büyük ve en küçük sayının toplamını
int olarak döndüren method yazın
 */

fun main(args: Array<String>) {

    numArray(intArrayOf(5,98,5,4,-8))

}

fun numArray(arr: IntArray): Int {
    var result = arr.min() + arr.max()
    println("Dizinin min ve max değerlerinin toplamı = $result")
    return result
}
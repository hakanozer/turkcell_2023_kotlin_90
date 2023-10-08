package com.works.turkcellodevler.Odev_2

/*
9 - parametre olarak bir int[]ve bir sayi
alan, eğer array sayiyi içeriyorsa true,
içermiyorsa false döndüren bir method yazin
 */

fun main(args: Array<String>) {

    val arr = intArrayOf(99,21,34,65,34,465)
    val num = 34

    if (isIncluded(arr,num) == true){
        println("Sayı dizi içerisinde bulunmaktadır.")
    }else{
        println("Sayı dizi içersinde bulunmamaktadır.")
    }


}

fun isIncluded(arr: IntArray, num: Int): Boolean{
    for (i in arr){
        if (i == num){
            return true
        }
    }
    return false
}
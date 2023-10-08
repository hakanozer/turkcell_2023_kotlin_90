package com.works.turkcellodevler.Odev_2
/*
4 - parametre olarak verilen long sayisinin
rakamlarinin toplamını döndüren methodu
yazin
 */

fun main(args: Array<String>) {

    sum(888888)

}

fun sum(num: Long): Long {
    var sumNums: Long = 0
    var remainder: Long = 0
    var tempNum: Long = num
    while (tempNum != 0L){
        remainder = (tempNum % 10L)
        sumNums += remainder
        tempNum /= 10
    }
    println("Girdiğiniz long sayısının rakamlarının toplamı: $sumNums")
    return sumNums
}
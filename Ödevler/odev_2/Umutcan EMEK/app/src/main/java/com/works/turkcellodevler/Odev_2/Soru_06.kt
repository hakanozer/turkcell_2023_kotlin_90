package com.works.turkcellodevler.Odev_2

/*
6 - parametre olarak verilen int sayinin
tersten yazilmiş halini int olarak döndüren
bir method yazin
 */

fun main(args: Array<String>) {

    reverse(541)

}

fun reverse(num: Int): Int {
    var reversed = 0
    var tempNum = num
    println("$tempNum sayının tersten yazılmış hali: ")
    while (tempNum > 0){
        reversed = tempNum % 10
        tempNum = tempNum / 10
        print(reversed)
    }

    return reversed
}
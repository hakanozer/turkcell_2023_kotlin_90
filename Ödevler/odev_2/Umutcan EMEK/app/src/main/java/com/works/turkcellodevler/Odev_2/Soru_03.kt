package com.works.turkcellodevler.Odev_2

/*
3 - Parametre olarak 2 int sayi alan (a,b),
ilk sayi tek ise a/b'yi,
ilk sayi çift ise a%b'yi double olarak
döndüren bir method yazın
 */

fun main(args: Array<String>) {

    div(13,0)

}

fun div(a: Int,b: Int): Any {
    var result = 0

    try {
        result = a / b
        if (a % 2 == 1){
            println("Sonuç: $result")
        }else{
            println("Sonuç: ${result.toDouble()}")
        }
    }catch (Ex: Exception){
        println("Bölen sayı 0 olamaz.")
    }
    return result
}
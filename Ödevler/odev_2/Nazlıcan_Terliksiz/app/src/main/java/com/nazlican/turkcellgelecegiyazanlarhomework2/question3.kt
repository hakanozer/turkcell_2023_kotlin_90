package com.nazlican.turkcellgelecegiyazanlarhomework2

// Parametre olarak 2 int sayi alan (a,b),
//ilk sayi tek ise a/b'yi,
//ilk sayi çift ise a%b'yi double olarak
//döndüren bir method yazın

fun main(){

    println(process(7.0,14.0))
}

fun process(num1:Double, num2:Double):Double {
    var result:Double = 0.0

    if (num1 % 2 != 0.0) {
        result = num1 / num2
    } else if (num1 % 2 == 0.0) {
        result = num1 % num2
    }
   return result
}
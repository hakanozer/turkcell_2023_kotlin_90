package com.works.oopproject._5_Soru

fun main(args: Array<String>) {
    val n= 41
    val primeNesne = AsalMi()
    val primeFun = primeNesne.isPrime(n)
    if(primeFun) { //true ise
        println("$n bir asal sayıdır")
    }else{
        println("$n Asal sayı değildir") //false ise
    }
}
package com.works.odevler

/**
 * 6 - parametre olarak verilen int sayinin
 * tersten yazilmiş halini int olarak döndüren
 * bir method yazin
 */

fun main(args: Array<String>) {
    val a = 14545
    val sonuc = ters(a)
    println(sonuc)
}

fun ters(a:Int) : Int{
    var tersCevir:Int = 0
    var num = a

    while (num != 0){
        val basamak = num %10
        tersCevir = tersCevir * 10 + basamak
        num /= 10

    }
    return tersCevir
}

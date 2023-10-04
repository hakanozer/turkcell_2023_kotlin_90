package com.nazlican.turkcellgelecegiyazanlarhomework2

//parametre olarak verilen long sayisinin
//rakamlarinin toplamını döndüren methodu
//yazin

fun main() {
    val toplam =sum(12345)
    println("$toplam")
}

fun sum(num: Long): Long {
    var toplam: Long = 0
    var n = num

    while (n != 0L) {
        val rakam = n % 10
        toplam += rakam
        n /= 10
    }

    return toplam
}
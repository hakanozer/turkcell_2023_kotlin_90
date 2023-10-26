package com.example.sefasatilogluvize

fun main() {

    val asalSayi = DorduncuSoru().getSumOfAllPrimes(100)
    println("1'den n'e kadar olan asal sayilarin toplami $asalSayi")
    val asalSayiMi = DorduncuSoru().isPrime(4)
    println("Asal mi ? $asalSayiMi")


}
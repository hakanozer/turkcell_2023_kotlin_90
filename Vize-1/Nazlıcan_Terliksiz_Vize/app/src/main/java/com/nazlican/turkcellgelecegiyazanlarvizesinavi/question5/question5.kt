package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question5

fun main() {
    val sayi = 17
    val primeChecker: PrimeChecker = MyPrimeChecker()
    val asalMi = primeChecker.isPrime(sayi)
    if (asalMi) {
        println("$sayi asal")
    } else {
        println("$sayi asal değildir.")
    }
}
package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question4

abstract class PrimeHelper {

    abstract fun isPrime(number: Int): Boolean

    fun getSumOfAllPrimes(n: Int): Int {
        var sum = 0
        for (i in 2..n) {
            if (isPrime(i)) {
                sum += i
            }
        }
        return sum
    }
}
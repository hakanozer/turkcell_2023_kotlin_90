package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question4

class MyPrimeHelper : PrimeHelper() {
    override fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }
        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}
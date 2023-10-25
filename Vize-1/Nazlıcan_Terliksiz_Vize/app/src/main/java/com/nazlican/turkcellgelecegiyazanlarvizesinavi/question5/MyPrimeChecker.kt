package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question5

class MyPrimeChecker : PrimeChecker {
    override fun isPrime(sayi: Int): Boolean {
        if (sayi <= 1) {
            return false
        }
        for (i in 2 until sayi) {
            if (sayi % i == 0) {
                return false
            }
        }
        return true
    }
}
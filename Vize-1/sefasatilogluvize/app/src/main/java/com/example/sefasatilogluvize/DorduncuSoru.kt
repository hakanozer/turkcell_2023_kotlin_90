package com.example.sefasatilogluvize

class DorduncuSoru {
    fun getSumOfAllPrimes(n:Int):Int {
        var toplam = 0
        for (i in 2..n) {
            if (isPrime(i)) {
                toplam+=i
            }
        }
        return toplam
    }
    //5.SORU
    fun isPrime(number:Int):Boolean {
        if (number<=1) {
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
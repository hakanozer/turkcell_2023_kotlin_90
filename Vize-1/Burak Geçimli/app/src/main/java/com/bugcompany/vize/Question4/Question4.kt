package com.bugcompany.vize.Question4

import kotlin.math.sqrt

class Question4 : IQuestion4 {
    override fun getSumOfAllPrimes(number: Int): Int {
        var sum = 0
        for (num in 1..number) {
            if (isPrime(num)) {
                sum += num
            }
        }
        return sum

    }

    private fun isPrime(num: Int): Boolean {
        if (num <= 1) {
            return false
        }

        if (num == 2) {
            return true
        }

        for (i in 2 until num) {
            if (num % i == 0) {
                return false
            }
        }
        return true
    }


}









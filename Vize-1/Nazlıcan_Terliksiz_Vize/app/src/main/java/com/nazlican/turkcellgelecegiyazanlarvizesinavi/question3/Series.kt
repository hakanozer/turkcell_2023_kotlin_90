package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question3

open class Series {
    open fun calculateSeriesSum(n: Int): Double {
        var sum = 0.0
        var factorial = 1

        for (i in 1..n) {
            factorial *= i
            sum += i.toDouble() / factorial
        }
        return sum
    }
}
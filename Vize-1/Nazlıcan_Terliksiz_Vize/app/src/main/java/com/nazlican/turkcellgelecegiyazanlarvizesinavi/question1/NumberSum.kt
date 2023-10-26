package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question1

class NumbersSum : Operations {
    override fun sum(number: Int) {
        var sum = 0
        var temp = number
        while (temp != 0) {
            sum += temp % 10
            temp /= 10
        }
        println("Sum: $sum")
    }
}

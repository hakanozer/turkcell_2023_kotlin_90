package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question2

class ReverseNumber : Operations() {
    override fun reverse(number: Int) {
        var temp = number
        var reverse = 0

        while (temp!= 0) {
            val digit = temp % 10
            reverse = reverse * 10 + digit
            temp /= 10
        }
        println("Reversed: $reverse")
    }
}
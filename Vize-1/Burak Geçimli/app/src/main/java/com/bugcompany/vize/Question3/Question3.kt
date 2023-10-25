package com.bugcompany.vize.Question3


class Question3(private var number: Int) {

    fun sumNumber() {
        var sum = 1.0
        var fact = 1

        for (i in 2..number) {
            fact *= i
            sum += i.toDouble() / fact
        }

        println("Series sum: $sum")
    }

    companion object {
        fun sum(number: Int): Question3 {
            if (number < 0) {
                throw IllegalArgumentException("Sayı negatif olamaz")
            }
            return Question3(number)
        }
    }

}








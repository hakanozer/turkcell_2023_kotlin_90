package com.works.turkcell.vize1

class Number {

    fun sumNumber(number: Int): Int {
        var sum = 0
        var remainingNumber = number

        while (remainingNumber > 0){
            val num =remainingNumber % 10
            sum += num
            remainingNumber /= 10

        }
        return sum
    }
}
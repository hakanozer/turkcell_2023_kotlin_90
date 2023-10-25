package com.bugcompany.vize.Question5

class Question5(private val number: Int) {

    init {
        if (isPrime()) {
            println("$number sayısı asaldır")
        } else {
            println("$number sayısı asal değildir")
        }
    }

    private fun isPrime(): Boolean {
        if (number <= 1) {
            return false
        }
        if (number == 2) {
            return true
        }

        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }


}
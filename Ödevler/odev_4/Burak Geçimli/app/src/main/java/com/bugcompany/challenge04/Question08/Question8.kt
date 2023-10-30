package com.bugcompany.challenge04.Question08

class Question8 {

    fun sumList(numberList: List<Int>) {
        var sum = 0
        numberList.forEach {
            if (it > 0) {
                sum += it
            }
        }
        println("Sum:$sum")

    }
}
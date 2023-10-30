package com.bugcompany.challenge04.Question06

class Question6 {

    fun countOccurrences(list: List<Int>, value: Int){
        var count = 0
        for (item in list) {
            if (item == value) {
                count++
            }
        }
        println("$list listesinde $value değeri $count kadar vardır.")
    }
}
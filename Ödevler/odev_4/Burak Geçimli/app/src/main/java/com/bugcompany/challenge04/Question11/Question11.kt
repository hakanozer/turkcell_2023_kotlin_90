package com.bugcompany.challenge04.Question11

class Question11 {

    fun sort(list: List<Int>) {
        println("Sorted List")
        list.sorted().reversed().forEach {
            print("$it ")
        }
    }
}
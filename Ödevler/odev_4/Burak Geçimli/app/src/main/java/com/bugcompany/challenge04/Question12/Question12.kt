package com.bugcompany.challenge04.Question12

class Question12 {

    fun findCommonValue(list1: Set<Any>, list2: Set<Any>) {
        list1.forEach { item1 ->
            list2.forEach { item2 ->
                if (item1 == item2) {
                    println("Commont Value:$item1")
                }
            }
        }
    }
}
package com.bugcompany.challenge04.Question05

class Question5 {

    fun combineCollection(list: List<Int>, set: Set<Int>) {
        val combinedCollection = list.toMutableList()
        combinedCollection.addAll(set)

        combinedCollection.forEach {
            println(it)
        }
    }

}
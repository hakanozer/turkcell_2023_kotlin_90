package com.bugcompany.challenge04.Question09

class Question9 {

    fun findNotNull(mixedList: List<Any?>) {
        mixedList.filterNotNull().forEach {
            println(it)
        }
    }
}
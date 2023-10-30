package com.bugcompany.challenge04.Question01

import kotlin.random.Random

class Question1 {

    fun createRandomList() {
        List(6) { Random.nextInt(1, 49) }.forEach {
            println(it)
        }
    }

}
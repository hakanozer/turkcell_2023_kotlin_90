package com.bugcompany.challenge03

import java.io.File

class Question2() {

    fun createRandomNumber(fileName: String) {
        val file = File(fileName)

        for (i in 1..500) {
            val number = (-1000..1000).random()
            file.appendText("$number\n")
        }
    }
}


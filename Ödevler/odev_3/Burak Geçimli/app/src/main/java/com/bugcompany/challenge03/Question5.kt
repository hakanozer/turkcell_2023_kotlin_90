package com.bugcompany.challenge03

import java.io.File


class Question5 {
    fun reverse(source: File, target: File) {
        if (!target.exists()) {
            target.createNewFile()
        }
        target.writeText(source.readText().reversed())
        println("File successfully reversed and written to 'dump_reverse.txt' file.")
    }

}
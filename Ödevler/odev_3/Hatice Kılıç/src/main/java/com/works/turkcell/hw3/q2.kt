package com.works.turkcell.hw3

import java.io.File

import java.util.Random

fun main(args: Array<String>) {

    val filePath ="C:\\Users\\CAN OKTAY KILIC\\Desktop\\dosyasorusu.txt"

    var random = Random()
    val min = -1000
    val max = 1000

    try {
        val file = File(filePath)
        file.bufferedWriter().use {
            for(i in 1..500){
                val randomNumber = random.nextInt(max - min + 1) + min
                it.write("$randomNumber\n")
            }
        }

    }catch (ex:Exception){
        println(ex.message)

    }

}
package com.works.turkcell.hw3

import java.io.File

fun main(args: Array<String>) {
    try {
        val filePath  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\dump.txt"
        val dump = File(filePath)

        if(dump.exists()){
            val lines = dump.readLines().filter { it.length != 0 }.map { it.lowercase().trimIndent() }
            val word = lines.joinToString(" ")

            val words = word.split(Regex("\\s+"))

            val wordCount = words.groupingBy { it }.eachCount()

            val longWord = words.maxBy { it.length }
            val shortWord = words.minBy { it.length }

            wordCount.forEach { (word, count) ->
                println(" $word: $count kez geciyor ")
            }

            println("En uzun kelime: $longWord  ${longWord?.length ?: 0 } harf icerir")
            println("En kisa kelime: $shortWord ${shortWord?.length ?: 0 } harf icerir ")

        }else{
            println("Dosya yolu bulunamadi")
        }
    }catch (ex:Exception){
        println(ex.message)
    }






}
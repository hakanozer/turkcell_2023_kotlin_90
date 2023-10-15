package com.works.turkcell.hw3

import java.io.File

fun main(args: Array<String>) {

    try {
        val filePath  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\dosyasorusu.txt"
        var positiveNumber = 0
        var negativeNumber = 0
        var evenNumber = 0
        var oddNumber = 0

        val file = File(filePath )
        val data = file.readLines()
        // println("Dosyadaki sayilar: $dosyaOkuma")

        for (item in data){
            val number = item.toInt()
            if(number >= 0) {
                positiveNumber++
            }
            if(number < 0) {
                negativeNumber++
            }
            if(number % 2 == 0) {
                evenNumber++
            }
            else
                oddNumber++
        }

        println("Pozitif $positiveNumber")
        println("Negatif $negativeNumber")
        println("Cift $evenNumber")
        println("Tek $oddNumber")

    }catch (ex:Exception){
        println("Dosya Bulunamadi.")
    }


}


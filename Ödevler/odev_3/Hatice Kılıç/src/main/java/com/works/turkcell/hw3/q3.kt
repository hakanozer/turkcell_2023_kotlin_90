package com.works.turkcell.hw3

import java.io.File
import java.io.PrintWriter

fun main(args: Array<String>) {


    try {
        val filePath  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\dosyasorusu.txt"
        val file = File(filePath )
        val data = file.readLines()

        val filePath1  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\C.txt"
        val filePath2  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\T.txt"
        var ciftFile = File(filePath1)
        val tekFile = File(filePath2)

        val ciftPrintWriter = PrintWriter(ciftFile)
        val tekPrintWriter = PrintWriter(tekFile)

        for (item in data) {
            var number = item.toInt()
            if(number % 2 == 0){
                ciftPrintWriter.println(number)
            }else{
                tekPrintWriter.println(number)
            }
        }
        ciftPrintWriter.close()
        tekPrintWriter.close()

    }catch (ex:Exception){
        println(ex.message)
    }
}
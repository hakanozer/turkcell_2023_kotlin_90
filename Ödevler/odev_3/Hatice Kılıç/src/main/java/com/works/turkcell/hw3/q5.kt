package com.works.turkcell.hw3

import java.io.File

fun main(args: Array<String>) {

    try {
        val filePath  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\dump.txt"
        val dumpFile = File(filePath)
        val filePath1  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\dump_rev_1.txt"
        val dump_rev_1 = File(filePath1)

        dump_rev_1.createNewFile()
        dump_rev_1.writeText(dumpFile.readText().trimIndent().reversed())

    }catch (ex:Exception){
        println(ex.message)
    }
}
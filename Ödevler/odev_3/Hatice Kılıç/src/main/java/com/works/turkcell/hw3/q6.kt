package com.works.turkcell.hw3

import java.io.File

fun main(args: Array<String>) {

    val filePath  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\dump.txt"
    val dumpFile = File(filePath)
    val filePath2  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\dump_rev_2.txt"
    val dump_rev_2 = File(filePath2)

    dump_rev_2.createNewFile()

    val words = dumpFile.readText().split(" ")
    val reverseddump = words.map{ it.reversed() }.joinToString(" ").trimIndent()

    dump_rev_2.writeText(reverseddump)




}
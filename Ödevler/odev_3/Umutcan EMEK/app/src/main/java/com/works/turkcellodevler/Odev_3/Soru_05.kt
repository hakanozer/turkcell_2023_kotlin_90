package com.works.turkcellodevler.Odev_3

import java.io.File
import kotlin.math.pow

/*
#5. 4. Sorudaki dump.txt yi, dump_rev_1.txt Dosyasına Tersten Yazdırın
 */

fun main(args: Array<String>) {

    val dump = File("C:\\Users\\umutc\\Desktop\\dump.txt")
    val reverseDump = File("C:\\Users\\umutc\\Desktop\\dump_rev_1.txt")

    val scope = dump.readText()
    val reverseScope = scope.reversed()
    reverseDump.writeText(reverseScope)

    println("Dump dosyası, dump_rev_1 dosyasına tersten yazıldı.")
}


package com.works.turkcellodevler.Odev_3

import java.io.File

/*
#6. 4. Sorudaki dump.txt yi, dump_rev_2.txt Dosyasına, Kelime Sırasını Bozmadan Tersten Yazdırın

Örnek : ali topu at 		-->  ila upot ta
 */

fun main(args: Array<String>) {

    val dump = File("C:\\Users\\umutc\\Desktop\\dump.txt")
    val reverseDump = File("C:\\Users\\umutc\\Desktop\\dump_rev_2.txt")

    val scope = dump.readText()
    val word = scope.split(Regex("\\s+"))
    val reverseWord = word.map { it.reversed() }
    val reverseScope = reverseWord.joinToString(" ")
    reverseDump.writeText(reverseScope)

    println("Dump dosyası, dump_rev_2 dosyasına kelime sırası bozulmadan tersten yazıldı.")

}

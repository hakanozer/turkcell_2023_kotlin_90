package com.works.turkcell.hw2

fun main(args: Array<String>) {
    val backNumber = back(6789)
    println("$backNumber")
}
fun back (sayi: Int):Int{
   var number = sayi.toString().reversed().toInt()
    return number
}
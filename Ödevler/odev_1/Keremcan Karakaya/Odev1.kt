package com.work_turkcell._odev

fun main(args: Array<String>) {
println("Lütfen 3 tane sayı giriniz")
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    if (a + b >= c && a + c >= b && b + c >= a) {
        println("Üçgen Olur")
    } else {
        println("Üçgen Olmaz")
    }
}


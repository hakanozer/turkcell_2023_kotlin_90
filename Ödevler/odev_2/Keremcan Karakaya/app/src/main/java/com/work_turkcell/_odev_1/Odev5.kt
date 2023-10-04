package com.work_turkcell._odev_1

fun main(args: Array<String>) {
    println("Üç basamaklı bir sayı giriniz")
   val s = readLine()!!.toInt()
    if (s < 100 || s > 999) {
        println("Lütfen üç haneli bir sayı girin.")
    }
    else {
        val y = s / 100
        val o = (s / 10) % 10
        val b = s % 10
        val t = y + o + b
        println("$y + $o + $b = $t")
    }
}
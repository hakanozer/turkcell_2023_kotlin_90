package com.work_turkcell._odev

fun main(args: Array<String>) {
    println("Üç basamaklı bir sayı giriniz")
    val sayi = readLine()!!.toInt()
    if (sayi < 100 || sayi > 999) {
        println("Lütfen üç haneli bir sayı girin.")
    } else {
        val y = sayi / 100
        val o = (sayi / 10) % 10
        val b = sayi % 10
        val tersSayi = (b * 100) + (o * 10) + y
        println("Tersten yazılmış hali: $tersSayi")
    }
}
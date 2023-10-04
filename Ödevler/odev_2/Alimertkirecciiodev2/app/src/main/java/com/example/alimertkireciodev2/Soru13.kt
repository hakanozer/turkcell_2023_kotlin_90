package com.example.alimertkireciodev2

fun main() {
    val girilensayi = readLine()
    try {
        val sayi = girilensayi!!.toInt()
        if (sayi != null) {
            println("$sayi bir sayıdır.")
        } else {
            println("Girilen değer bir sayı değildir.")
        }
    } catch (e: NumberFormatException) {
        println("Girilen değer bir sayı değildir.")
    }
}
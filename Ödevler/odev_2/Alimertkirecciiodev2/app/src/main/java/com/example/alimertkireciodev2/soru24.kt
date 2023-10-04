package com.example.alimertkireciodev2

fun main(args: Array<String>) {
    try {
        println("Üç basamaklı bir sayı girin: ")
        val sayi = readLine()!!.toInt()
        if (sayi < 100 || sayi > 999) {
            println("Geçerli bir üç basamaklı sayı giriniz.")
            return
        }

        var originalNumber = sayi
        var result = 0

        while (originalNumber > 0) {
            val digit = originalNumber % 10
            result += digit * digit * digit
            originalNumber /= 10
        }

        if (result == sayi) {
            println("$sayi bir Armstrong sayısıdır.")
        } else {
            println("$sayi bir Armstrong sayısı değildir.")
        }
    } catch (ex:Exception) {
        println("Geçerli bir üç basamaklı sayı girin.")
    }
}

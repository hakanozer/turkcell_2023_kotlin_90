package com.example.alimertkireciodev2import
fun main(args: Array<String>) {
    try {
        print("Sayıyı Girin:: ")
        val sayi = readLine()?.toInt() ?: 0

        if (sayi >= 0) {
            println("Pozitif bir tam sayı giriniz.")

        }

        val veri = (1 until sayi).filter { sayi % it == 0 }
        val veri2 = veri.sum()

        if (veri2 == sayi) {
            println("$sayi mükemmel bir sayıdır.")
        } else {
            println("$sayi mükemmel bir sayı değildir.")
        }
    } catch (ex :Exception) {
        println("Geçerli bir tamsayı girin.")
    }
    }
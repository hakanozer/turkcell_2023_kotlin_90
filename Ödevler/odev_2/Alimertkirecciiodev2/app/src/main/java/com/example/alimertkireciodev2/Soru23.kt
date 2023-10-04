package com.example.alimertkireciodev2

fun main(args: Array<String>) {
    try {
        print("Bir sayı girin: ")
        val sayi = readLine()!!.toDouble()

        if (sayi < 0) {
            println("Negatif bir sayı girmeyin.")
            return
        }

        val Karekök = Math.sqrt(sayi)
        println("Girdiğiniz sayının karekökü: $Karekök")
    } catch (ex: Exception) {
        println("Geçerli bir sayı girin.")
    }
}

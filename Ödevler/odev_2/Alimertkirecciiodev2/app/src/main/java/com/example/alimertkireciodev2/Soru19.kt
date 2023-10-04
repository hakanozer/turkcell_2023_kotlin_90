package com.example.alimertkireciodev2

import java.lang.Exception
// Kullanıcıdan dört basamaklı bir sayı alınız. Alınan sayının 2 ile bölümünden
// kalanın sıfır olup olmadığını try-catch ile kontrol eden bir program yazınız.
fun main(args: Array<String>) {
    try {
        print("Dört basamaklı sayı girin ")
        val girilenSayi = readLine()!!.toInt()

        if (girilenSayi in 1000..9999) {
            if (girilenSayi % 2 == 0) {
                println("bölümünden kalan sıfır!")
            } else {
                println("Kalan 0 değildir!.")
            }
        } else {
            println("Sayı 4 Basamaklı değil")
        }
    } catch (ex :Exception) {
        println("Hatalı giriş")
    }
}

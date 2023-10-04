package com.example.alimertkireciodev2

import java.lang.Exception

fun main(args: Array<String>) {
    try {
        print("Liste boyutu: ")
        val uzunluk = readLine()!!.toInt()
        if (uzunluk <= 0) {
            println("Geçersiz boyut!")
            return
        }
        val liste = mutableListOf<Int>()

        for (i in 0 until uzunluk) {
            print("Girdi $i: ")
            val girdi = readLine()!!.toInt()
            liste.add(girdi)
        }
        var tekIndeksToplam = 0
        var ciftIndeksToplam = 0
        for (i in 0 until uzunluk) {
            if (i % 2 == 0) {
                ciftIndeksToplam += liste[i]
            } else {
                tekIndeksToplam += liste[i]
            }
        }
        println("Tek İndeksteki Tamsayıların Toplamı: $tekIndeksToplam")
        println("Çift İndeksteki Tamsayıların Toplamı: $ciftIndeksToplam")
    } catch (ex: Exception) {
        println("Hatalı giriş! Geçerli bir tam sayı girin.")
    }
}
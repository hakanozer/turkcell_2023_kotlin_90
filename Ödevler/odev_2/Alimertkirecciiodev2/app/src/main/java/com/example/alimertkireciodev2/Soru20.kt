package com.example.alimertkireciodev2

fun main(args: Array<String>) {
    val Girilendeğerler = mutableListOf<Int>()
    try {for (i in 1..5) {
            print("Lütfen 0 ile 20 arasında bir sayı girin: ")
            val Sayılar = readLine()!!.toInt()
        if (Sayılar < 0 || Sayılar > 20) {
            println("Hatalı giriş! Lütfen 0 ile 20 arasında bir sayı girin.")
            }
            Girilendeğerler.add(Sayılar)
        }
    } catch (ex: Exception) {
        println("Hatalı giriş! Lütfen Sayı olarak Giriniz!")
    }
    val tekSayilar = mutableListOf<Int>()
    val ciftSayilar = mutableListOf<Int>()
    for (sayi in Girilendeğerler) {
        if (sayi % 2 == 0) {
            ciftSayilar.add(sayi)
        } else {
            tekSayilar.add(sayi)
        }
    }
    println("Tek Sayılar: $tekSayilar")
    println(" Çift Sayılar: $ciftSayilar")
    val tekOrtalama = tekSayilar.average()
    val ciftOrtalama = ciftSayilar.average()
    println("Tek  Ortalaması: $tekOrtalama")
    println("Çift  Ortalaması: $ciftOrtalama")
}
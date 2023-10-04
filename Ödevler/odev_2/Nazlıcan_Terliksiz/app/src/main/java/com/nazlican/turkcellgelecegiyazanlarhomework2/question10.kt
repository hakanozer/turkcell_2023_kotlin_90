package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.Scanner

//kullanıcıdan 4 tane int değer alan,
//ve en büyük olan değeri geri döndüren bir
//method yazın

fun main() {
    val enBuyukSayi = enBuyuguBul()
    println("En büyük sayı: $enBuyukSayi")
}
fun enBuyuguBul(): Int {
    val scanner = Scanner(System.`in`)
    val sayilar = IntArray(4)

    for (i in 0 until 4) {
        print("Sayı $i: ")
        sayilar[i] = scanner.nextInt()
    }

    var enBuyuk = sayilar[0]

    for (sayi in sayilar) {
        if (sayi > enBuyuk) {
            enBuyuk = sayi
        }
    }

    return enBuyuk
}
package com.nazlican.turkcellhomework1

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("Kaç sayı gireceksiniz: ")
    val n = scanner.nextInt()

    var pozitifSayisi = 0
    var negatifSayisi = 0
    var enBuyuk = Int.MIN_VALUE
    var enKucuk = Int.MAX_VALUE
    var toplam = 0
    var ciftSayisi = 0
    var tekSayisi = 0

    for (i in 1..n) {
        print("Sayı $i: ")
        val sayi = scanner.nextInt()

        if (sayi > 0) {
            pozitifSayisi++
        } else if (sayi < 0) {
            negatifSayisi++
        }

        if (sayi > enBuyuk) {
            enBuyuk = sayi
        }

        if (sayi < enKucuk) {
            enKucuk = sayi
        }

        if (sayi % 2 == 0) {
            ciftSayisi++
        } else {
            tekSayisi++
        }

        toplam += sayi
    }

    val ortalama = toplam.toDouble() / n

    println("$pozitifSayisi Pozitif")
    println("$negatifSayisi Negatif")
    println("En Büyük : $enBuyuk")
    println("En Küçük : $enKucuk")
    println("$ciftSayisi Çift")
    println("$tekSayisi Tek")
    println("Toplam : $toplam")
    println("Ortalama : $ortalama")
}





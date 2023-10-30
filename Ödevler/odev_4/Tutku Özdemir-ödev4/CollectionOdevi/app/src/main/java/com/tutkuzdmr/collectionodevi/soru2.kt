package com.tutkuzdmr.collectionodevi

fun main(args: Array<String>) {
    val sayi1 = "23456789876543234567890987654567890"
    val sayi2 = "99999999999988888888882222222688981"

    // Sayıları ters çevir
    val tersSayi1 = sayi1.reversed()
    val tersSayi2 = sayi2.reversed()

    val toplam = StringBuilder()
    var elde = 0

    val maxUzunluk = maxOf(tersSayi1.length, tersSayi2.length)

    for (i in 0 until maxUzunluk) {
        val basamak1 = if (i < tersSayi1.length)
            Character.getNumericValue(tersSayi1[i])
        else 0

        val basamak2 = if (i < tersSayi2.length)
            Character.getNumericValue(tersSayi2[i])
        else 0

        val toplamBasamak = basamak1 + basamak2 + elde
        elde = toplamBasamak / 10
        val sonucBasamak = toplamBasamak % 10

        toplam.insert(0, sonucBasamak)
    }

    if (elde > 0) {
        toplam.insert(0, elde)
    }

    println("Toplam: ${toplam.toString()}")
}

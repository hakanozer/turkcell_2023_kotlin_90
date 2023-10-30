package com.tutkuzdmr.collectionodevi

fun main(args: Array<String>) {

    val min = 1
    val max = 49
    val secilenSayilar = mutableListOf<Int>()

    while (secilenSayilar.size < 6) {
        val rastgeleSayi = (min..max).random()
        if (rastgeleSayi !in secilenSayilar) {
            secilenSayilar.add(rastgeleSayi)
        }
    }

    println("Rastgele Seçilen 6 Sayı:")
    for (sayi in secilenSayilar) {
        print("$sayi ")
    }
}
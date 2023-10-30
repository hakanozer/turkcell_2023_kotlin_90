package com.tutkuzdmr.collectionodevi

fun <T> sayiTekrarSayisi(liste: List<T>, deger: T): Int {
    var sayac = 0
    for (eleman in liste) {
        if (eleman == deger) {
            sayac++
        }
    }
    return sayac
}

fun main(args: Array<String>) {

    val liste = listOf(1, 2, 2, 3, 4, 2, 5, 2, 6)
    val arananDeger = 2

    val tekrarSayisi = sayiTekrarSayisi(liste, arananDeger)

    println("$arananDeger değeri listede $tekrarSayisi kez tekrarlandı.")
}
package com.works.odev.Ödev4

/**
 * 5. Bir Set ve bir List oluşturun. Set'teki benzersiz elemanları, List'teki sırayla bulunan elemanları koruyarak birleştirin.
 * Sonuçta nasıl bir koleksiyon elde edersiniz, bunu ekrana yazdırın.
 */
fun main(args: Array<String>) {
    val set = mutableSetOf<String>("ali","mehmet","murat")
    val liste = listOf<Int>(10,7,11,9,17)

    val birlestir = set.plus(liste)
    println(birlestir)
}
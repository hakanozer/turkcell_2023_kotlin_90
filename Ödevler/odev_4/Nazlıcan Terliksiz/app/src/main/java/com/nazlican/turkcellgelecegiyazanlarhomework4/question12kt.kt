package com.nazlican.turkcellgelecegiyazanlarhomework4

fun main() {
    val set1 = setOf("elma", "portakal", "muz", "şeftali", "kivi")
    val set2 = setOf("portakal", "mandalina", "muz", "nektari", "şeftali")

    val ortak = set1.intersect(set2)

    if (ortak.isEmpty()) {
        println("Ortak eleman bulunamadı.")
    } else {
        println("Ortak Elemanlar:")
        for (element in ortak) {
            println(element)
        }
    }
}
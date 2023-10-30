package com.nazlican.turkcellgelecegiyazanlarhomework4

fun main() {
    val list = listOf("Nazlıcan", "gülcan", "oğuzhan")

    val shortest = list.minByOrNull { it.length }
    val longest = list.maxByOrNull { it.length }

    if (shortest != null && longest != null) {
        println("En kısa metin: $shortest")
        println("En uzun metin: $longest")
    } else {
        println("Liste boş.")
    }
}
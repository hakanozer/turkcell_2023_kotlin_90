package com.tutkuzdmr.collectionodevi

fun main(args: Array<String>) {

    val yasListesi = listOf(20, 25, 18, 30, 22, 28, 17, 19, 40, 50, 60)

    val yasGruplari = mutableMapOf<String, MutableList<Int>>()

    for (yas in yasListesi) {
        val yasGrubu = when (yas) {
            in 0..17 -> "0-17"
            in 18..24 -> "18-24"
            in 25..34 -> "25-34"
            in 35..49 -> "35-49"
            else -> "50+"
        }

        if (!yasGruplari.containsKey(yasGrubu)) {
            yasGruplari[yasGrubu] = mutableListOf()
        }

        yasGruplari[yasGrubu]?.add(yas)
    }

    println("Yaş Grupları:")
    for ((yasGrubu, insanlar) in yasGruplari) {
        println("$yasGrubu yaş aralığındaki insanlar: $insanlar")
    }
}
package com.tutkuzdmr.collectionodevi

fun <T> nullOlmayanElemanlariFiltrele(liste: List<T?>): List<T> {
    return liste.filterNotNull()
}

fun main(args: Array<String>) {

    val karmaListe = listOf(1, 2, "Tutku", null, 3.14, null)

    val temizListe = nullOlmayanElemanlariFiltrele(karmaListe)

    println("Null olmayan elemanlar: $temizListe")

}
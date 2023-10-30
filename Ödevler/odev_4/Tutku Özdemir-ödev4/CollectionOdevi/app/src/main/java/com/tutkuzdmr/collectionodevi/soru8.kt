package com.tutkuzdmr.collectionodevi

fun main(args: Array<String>) {

    fun toplamPozitifSayilar(liste: List<Int>): Int {
        return liste.filter { it > 0 }.sum()
    }

    fun main() {
        val liste = listOf(1, 3, -2, 5, -7, 4, 8, -1, 6)

        val pozitifToplam = toplamPozitifSayilar(liste)

        println("Listedeki pozitif sayıların toplamı: $pozitifToplam")
    }
}
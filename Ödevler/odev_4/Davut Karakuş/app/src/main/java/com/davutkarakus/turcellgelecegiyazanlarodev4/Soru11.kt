package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru11 {
    private fun siralaBüyüktenKücüge(liste: List<Int>): List<Int> {
        return liste.sortedDescending()
    }
    fun siraliListe() {
        val rastgeleSayilar = listOf(45, 23, 67, 12, 89, 5, 33)
        val siraliListe = siralaBüyüktenKücüge(rastgeleSayilar)
        println("Buyukten kucuge siralanmis liste: $siraliListe")
    }
}
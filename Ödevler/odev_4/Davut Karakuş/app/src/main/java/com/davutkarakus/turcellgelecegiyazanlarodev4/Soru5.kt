package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru5 {
    fun setAndList() {
        val setim = setOf("Elma", "Muz", "Portakal")
        val listem = listOf("Uzum", "Karpuz", "Elma")

        val birlesikListe = ArrayList(listem)

        for (eleman in setim) {
            if (eleman !in listem) {
                birlesikListe.add(eleman)
            }
        }
        println(birlesikListe)
    }
}
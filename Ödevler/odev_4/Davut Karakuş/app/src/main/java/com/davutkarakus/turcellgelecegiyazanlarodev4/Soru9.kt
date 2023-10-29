package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru9 {
    private fun nullOlmayanlariFiltrele(liste: List<Any?>): List<Any> {
        return liste.filterNotNull()
    }
    fun filtrele() {
        val karisikListe = listOf("Ben","Davut", null, 26, null, 96, "Karakus")
        val temizListe = nullOlmayanlariFiltrele(karisikListe)
        println(temizListe)
    }
}
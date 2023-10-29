package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru10 {
    fun uzunlugaGoreSirala() {
        val metinListesi = listOf("Davut", "KARAKUS", "Adana", "Cukurova", "Universite", "26")
        val enKisaMetin = metinListesi.minByOrNull { it.length }
        val enUzunMetin = metinListesi.maxByOrNull { it.length }
        val siraliListe = metinListesi.sortedBy { it.length }
        println("Sirali Liste: $siraliListe")
        println("En kisa metin: $enKisaMetin")
        println("En uzun metin: $enUzunMetin")
    }
}
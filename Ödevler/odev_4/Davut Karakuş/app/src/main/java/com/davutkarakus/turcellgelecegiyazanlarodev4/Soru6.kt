package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru6 {

    private fun sayiHesapla(liste: List<String>, deger: String): Int {
        return liste.count { it == deger }
    }

    fun tekrarYazdir() {
        val ornekListe = listOf("Elma", "Muz", "Elma", "Portakal", "Elma", "Karpuz")
        val meyve = "Elma"
        val tekrarSayisi = sayiHesapla(ornekListe, meyve)
        println("$meyve kelimesi listemizde $tekrarSayisi kez tekrarlanmistir.")
    }
}
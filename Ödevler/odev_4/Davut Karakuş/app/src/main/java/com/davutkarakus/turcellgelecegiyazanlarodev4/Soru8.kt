package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru8 {

    private fun pozitifToplamiHesapla(liste: List<Int>): Int {
        return liste.filter { it > 0 }.sum()
    }

    fun toplam() {
        val sayilar = listOf(15, -20, 23, 30, -40, 50, -60, 70, 10)
        val toplam = pozitifToplamiHesapla(sayilar)
        println("Listedeki pozitif sayilarin toplami: $toplam")
    }
}
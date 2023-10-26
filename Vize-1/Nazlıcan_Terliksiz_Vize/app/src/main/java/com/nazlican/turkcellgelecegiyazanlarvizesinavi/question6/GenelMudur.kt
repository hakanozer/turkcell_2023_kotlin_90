package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question6

class GenelMudur(maas: Double) : Personel(maas) {
    override fun maasHesapla(ekSaat: Int): Double {
        return maas + (ekSaat * 0.8)
    }
}
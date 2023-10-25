package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question6

class Memur(maas: Double) : Personel(maas) {
    override fun maasHesapla(ekSaat: Int): Double {
        return maas + (ekSaat * 0.3)
    }
}
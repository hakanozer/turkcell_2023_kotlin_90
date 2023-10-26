package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question6

class Mudur(maas: Double) : Personel(maas) {
    override fun maasHesapla(ekSaat: Int): Double {
        return maas + (ekSaat * 0.6)
    }
}
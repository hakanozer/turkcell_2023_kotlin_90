package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question6

open class Personel(val maas: Double) {
    open fun maasHesapla(ekSaat: Int): Double {
        return maas + (ekSaat * 0.0)
    }
}
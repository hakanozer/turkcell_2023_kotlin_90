package com.davutkarakus.turkcellgelecegiyazanlarvize

open class Personel(private val maas:Int, private val ekSaat:Int) {
    open val ekSaatKatSayisi : Double = 0.0

    fun maasHesapla() : Double {
        return maas + (ekSaat * ekSaatKatSayisi)
    }
}

class Memur(ekSaat: Int) : Personel(1000,ekSaat){
    override val ekSaatKatSayisi = 0.3
}

class Mudur(ekSaat: Int) : Personel(3000,ekSaat){
    override val ekSaatKatSayisi = 0.6
}

class GenelMudur(ekSaat: Int) : Personel(5000,ekSaat){
    override val ekSaatKatSayisi = 0.8
}
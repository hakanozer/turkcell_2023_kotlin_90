package com.works.oopproject._3_Soru

class SeriToplami {
    fun seriHesaplama (n : Int) : Double {
        var toplam = 0.0
        var faktoriyel = 1
        for(i in 1..n) {
            faktoriyel = faktoriyel * i
            toplam = toplam + i.toDouble()/faktoriyel.toDouble()
        }
        return toplam
    }
}
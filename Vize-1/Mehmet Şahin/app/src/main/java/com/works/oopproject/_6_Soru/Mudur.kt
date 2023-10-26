package com.works.oopproject._6_Soru

class Mudur: EkMesai(3000.0) {
    override fun maasHesaplama(): Double {
        val mudurMaasi = ekMesai + (ekMesai * 0.6)
        return mudurMaasi
    }
}
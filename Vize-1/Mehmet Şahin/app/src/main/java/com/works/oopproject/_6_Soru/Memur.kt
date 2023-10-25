package com.works.oopproject._6_Soru

class Memur : EkMesai(1000.0) {
    override fun maasHesaplama(): Double {
        val memurMaasi = ekMesai + (0.3 * ekMesai)
        return memurMaasi
    }
}
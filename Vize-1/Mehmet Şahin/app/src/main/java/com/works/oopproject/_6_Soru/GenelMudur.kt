package com.works.oopproject._6_Soru

class GenelMudur : EkMesai(5000.0) {
    override fun maasHesaplama(): Double {
        val genelMudurMaas = ekMesai + (0.8 * ekMesai)
        return genelMudurMaas
    }

}
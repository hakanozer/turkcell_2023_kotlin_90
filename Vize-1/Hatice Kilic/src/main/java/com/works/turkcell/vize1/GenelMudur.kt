package com.works.turkcell.vize1

open class GenelMudur: OrtakCalisan(5000.0) {

    override fun mesaiHesaplama(calismaSaati: Int):Double {
        return super.mesaiHesaplama(calismaSaati) +(0.8 * calismaSaati)



}
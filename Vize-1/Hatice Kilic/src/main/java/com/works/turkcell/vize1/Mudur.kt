package com.works.turkcell.vize1

open class Mudur: OrtakCalisan(3000.0){

    override fun mesaiHesaplama(calismaSaati: Int):Double {
        return super.mesaiHesaplama(calismaSaati) +(0.6 * calismaSaati)



}
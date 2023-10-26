package com.works.turkcell.vize1

open class Memur : OrtakCalisan(1000.0) {

    override fun mesaiHesaplama(calismaSaati: Int):Double {
          return  super.mesaiHesaplama(calismaSaati) +(0.3 * calismaSaati)
    }




}
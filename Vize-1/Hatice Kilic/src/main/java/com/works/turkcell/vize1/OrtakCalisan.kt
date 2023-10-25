package com.works.turkcell.vize1

open class OrtakCalisan (val saatlikUcret: Double){

    open fun mesaiHesaplama (calismaSaati: Int) : Double{
        return calismaSaati * saatlikUcret

    }

}
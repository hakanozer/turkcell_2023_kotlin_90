package com.works.odev5._Ödev5_

interface araba {
    fun fiyat ()
}

class mercedesamg (val yili : Int) : araba{
    override fun fiyat() {
        println("Mercedes AMG , $yili model araç fiyatınız : 3.761.000 TL")
    }
}

fun arabafiyatogrenme(arabafiyati  : araba){
    arabafiyati.fiyat()
}


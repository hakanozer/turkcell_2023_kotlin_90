package com.gorkemarslanbogan.kotlinvize.Vize

open class Personel(val aylikMaas: Double, val mesaiOrani: Double) {
    open fun maasHesapla(ekCalisilanSaat: Int) : Double {
        val gunlukUcret = aylikMaas / 30
        val saatlikUcret = gunlukUcret / 8
        return aylikMaas + (saatlikUcret * mesaiOrani * ekCalisilanSaat)
    }
}

class Memur(maas: Double, mesaiOrani: Double) : Personel(maas, mesaiOrani)

class Mudur(maas: Double, mesaiOrani: Double) : Personel(maas, mesaiOrani)

class GenelMudur(maas: Double, mesaiOrani: Double) : Personel(maas, mesaiOrani)
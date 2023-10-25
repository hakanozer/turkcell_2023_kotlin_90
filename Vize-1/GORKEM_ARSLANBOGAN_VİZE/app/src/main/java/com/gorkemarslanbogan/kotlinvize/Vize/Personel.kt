package com.gorkemarslanbogan.kotlinvize.Vize

open class Personel(val aylikMaas: Double) {
    open fun maasHesapla(ekCalisilanSaat: Int) : Double {
        return aylikMaas
    }
}

class Memur(val maas: Double) : Personel(maas) {
    override fun maasHesapla(ekCalisilanSaat: Int): Double {
        val gunlukUcret = maas / 30
        val saatlikUcret = gunlukUcret / 8
        val toplamYapilanMesaiSaati = saatlikUcret * 0.3 * ekCalisilanSaat
        return maas + toplamYapilanMesaiSaati
    }
}

class Mudur(val maas: Double) : Personel(maas) {
    override fun maasHesapla(ekCalisilanSaat: Int): Double {
        val gunlukUcret = maas / 30
        val saatlikUcret = gunlukUcret / 8
        val toplamYapilanMesaiSaati = saatlikUcret * 0.6 * ekCalisilanSaat
        return maas + toplamYapilanMesaiSaati
    }
}

class GenelMudur(val maas: Double) : Personel(maas) {
    override fun maasHesapla(ekCalisilanSaat: Int): Double {
        val gunlukUcret = maas / 30
        val saatlikUcret = gunlukUcret / 8
        val toplamYapilanMesaiSaati = saatlikUcret * 0.8 * ekCalisilanSaat
        return maas + toplamYapilanMesaiSaati
    }
}
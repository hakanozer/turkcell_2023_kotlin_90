package com.works.turkcell_sinav_1.Soru_6

class Memur(ekSaatUcreti: Double) : Calisan(ekSaatUcreti) {
    override fun hesaplaMaas(): Double {
        return 1000.0 + ekSaatUcreti * 0.3
    }
}
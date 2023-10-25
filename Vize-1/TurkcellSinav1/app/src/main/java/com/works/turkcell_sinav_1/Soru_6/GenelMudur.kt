package com.works.turkcell_sinav_1.Soru_6

class GenelMudur(ekSaatUcreti: Double) : Calisan(ekSaatUcreti) {
    override fun hesaplaMaas(): Double {
        return 5000.0 + ekSaatUcreti * 0.8
    }
}
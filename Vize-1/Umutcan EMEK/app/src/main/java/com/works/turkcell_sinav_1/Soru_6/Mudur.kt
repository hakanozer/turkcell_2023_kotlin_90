package com.works.turkcell_sinav_1.Soru_6

class Mudur(ekSaatUcreti: Double) : Calisan(ekSaatUcreti) {
    override fun hesaplaMaas(): Double {
        return 3000.0 + ekSaatUcreti * 0.6
    }
}
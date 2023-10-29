package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru2 {
    fun longStringToInt() {
        val a = "23456789876543234567890987654567890"
        val b = "99999999999988888888882222222688981"
        val maxUzunluk = maxOf(a.length, b.length)
        val num1 = a.padStart(maxUzunluk, '0')
        val num2 = b.padStart(maxUzunluk, '0')

        var bolum = 0
        val sonuc = StringBuilder()

        for (i in maxUzunluk - 1 downTo 0) {
            val sum = (num1[i] - '0') + (num2[i] - '0') + bolum
            sonuc.append(sum % 10)
            bolum = sum / 10
        }

        if (bolum > 0) {
            sonuc.append(bolum)
        }
        println("Toplam : ${sonuc.reversed()}")
    }
}
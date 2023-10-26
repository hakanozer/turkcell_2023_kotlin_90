package com.works.turkcell_sinav_1.Soru_6

fun main(args: Array<String>) {

    val ekSaatUcreti = 200.0

    val memur = Memur(ekSaatUcreti)
    val mudur = Mudur(ekSaatUcreti)
    val genelMudur = GenelMudur(ekSaatUcreti)

    println("Ek saatlerle güncel memur maaşı: ${memur.hesaplaMaas()} TL")
    println("Ek saatlerle güncel müdür maaşı: ${mudur.hesaplaMaas()} TL")
    println("Ek saatlerle güncel genel müdür maaşı: ${genelMudur.hesaplaMaas()} TL")

}


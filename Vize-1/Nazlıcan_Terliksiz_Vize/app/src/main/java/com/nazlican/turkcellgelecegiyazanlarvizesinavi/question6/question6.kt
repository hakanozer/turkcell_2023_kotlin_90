package com.nazlican.turkcellgelecegiyazanlarvizesinavi.question6

fun main() {
    val memur = Memur(1000.0)
    val mudur = Mudur(3000.0)
    val genelMudur = GenelMudur(5000.0)

    val ekSaatMemur = 10
    val ekSaatMudur = 20
    val ekSaatGenelMudur = 30

    println("Memurun toplam maaşı: ${memur.maasHesapla(ekSaatMemur)} TL")
    println("Müdürün toplam maaşı: ${mudur.maasHesapla(ekSaatMudur)} TL")
    println("Genel Müdürün toplam maaşı: ${genelMudur.maasHesapla(ekSaatGenelMudur)} TL")
}
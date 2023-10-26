package com.works.myapplication.Cozumler._6_

fun main(args: Array<String>) {
    // normal mesai günde 10 saat ve 1 ayda 20 gün bazlı hesaplanmıstır.
    var memur = CalisanOrtak(1000,5)
    var mudur = CalisanOrtak(3000,15)
    var genelMudur = CalisanOrtak(5000,25)

    var memurMaasi = memur.toplamMaas(12)
    var mudurMaasi = mudur.toplamMaas(12)
    var genelMudurMaasi = genelMudur.toplamMaas(12)

    println(memurMaasi)
    println(mudurMaasi)
    println(genelMudurMaasi)


}
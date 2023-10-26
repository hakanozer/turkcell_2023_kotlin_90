package com.davutkarakus.turkcellgelecegiyazanlarvize

fun main(args: Array<String>) {

    val basamakToplamObj = BasamakToplami()
    basamakToplamObj.basamakToplami()

    val sayiyiTerstenYazdirObj = SayiyiTerstenYazdir()
    sayiyiTerstenYazdirObj.terstenYazdir()

    val seriHesapla = SeriHesapla(4)
    seriHesapla.hesapla()

    val asalSayiToplam = AsalSayiToplam(31)
    asalSayiToplam.getSumOfAllPrimes()

    val asalMi = CheckPrime(31)
    println(asalMi.isPrime())

    val memur = Memur(5)
    val mudur = Mudur(6)
    val genelMudur = GenelMudur(7)
    println("Memur maasi : ${memur.maasHesapla()}")
    println("Mudur maasi : ${mudur.maasHesapla()}")
    println("Genel Mudur maasi : ${genelMudur.maasHesapla()}")
}
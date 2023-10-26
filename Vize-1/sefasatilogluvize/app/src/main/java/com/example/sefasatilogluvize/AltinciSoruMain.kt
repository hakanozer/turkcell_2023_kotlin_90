package com.example.sefasatilogluvize

fun main() {

    val memur = Memur("Ahmet","Memur")
    memur.PersonelBilgileriGoster()
    memur.maasextraHesapla(10.0)
    println("************************************")
    val mudur = Mudur("Selcuk","Mudur")
    mudur.PersonelBilgileriGoster()
    mudur.maasextraHesapla(20.0)
    println("************************************")
    val genelMudur = GenelMudur("Sefa","Genel Mudur")
    genelMudur.PersonelBilgileriGoster()
    genelMudur.maasextraHesapla(2.0)







}
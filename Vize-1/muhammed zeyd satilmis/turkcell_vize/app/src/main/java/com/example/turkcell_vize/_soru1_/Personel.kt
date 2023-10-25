package com.example.turkcell_vize._soru1_

abstract class Personel {

    abstract var isim: String
    abstract var maas: Int
    abstract var ekSaatUcreti: Double
    abstract var  maasKatsayisi: Int


     fun maasHesapla(){
         val toplamMaas = maas + ekSaatUcreti * maasKatsayisi
         println("$isim toplam maaş: $toplamMaas")


     }
}
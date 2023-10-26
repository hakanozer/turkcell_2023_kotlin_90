package com.example.sefasatilogluvize

open class AltinciSoru(var ad:String , var pozisyonu:String,var maas:Double){

    init {
        println("Nesne Olusturuldu!")
    }
    open fun PersonelBilgileriGoster() {
        println("Ad: $ad")
        println("Pozisyonu: $pozisyonu")
        println("Maas: $maas TL'dir")

    }
    open fun maasextraHesapla(saatlikUcret:Double) {
        val saatUcreti = saatlikUcret
        val ekUcret = maas * saatUcreti
        maas+= ekUcret
        println("Ekstra saat calistiniz yeni maasiniz: $maas TL'dir")

    }
}
class Memur(ad: String,pozisyonu: String,maas: Double = 1000.0):AltinciSoru(ad, pozisyonu, maas) {
    override fun maasextraHesapla(saatlikUcret: Double) {
        super.maasextraHesapla(0.3)
    }
}
class Mudur(ad: String,pozisyonu: String,maas: Double=3000.0):AltinciSoru(ad, pozisyonu, maas) {

    override fun maasextraHesapla(saatlikUcret: Double) {
       super.maasextraHesapla(0.6)
    }
}
class GenelMudur(ad: String,pozisyonu: String,maas: Double=5000.0):AltinciSoru(ad, pozisyonu, maas) {

    override fun maasextraHesapla(saatlikUcret: Double) {
        super.maasextraHesapla(0.8)
    }
}
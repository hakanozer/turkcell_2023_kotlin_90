package com.works.odev.Odev5

class Asus:Bilgisayar(),OyunOyna {
    override fun bilgisayariAc() {
        println("Bilgisayar açıldı !")
    }

    override fun oyna() {
        println("Oyun oynanıyor !")
    }
}
package com.example.odev_5.sorubes

open class Hayvan {

    fun sesCikar() {
        println("ses çıkarıldı")
    }

    fun yemekYe() {
        println("yemek yenildi")
    }

}

class Kopek : Hayvan() {

    fun havla() {
        println("Köpek havlıyor")
    }
}

class Kedi : Hayvan() {

    fun miyavla() {
        println("Kedi miyavlıyor")
    }
}

/// polimorfizm
fun main() {
    var hayvan = Hayvan()
    var kopek = Kopek()
    var kedi = Kedi()

    hayvan.sesCikar()
    hayvan.yemekYe()

    kopek.sesCikar()
    kopek.yemekYe()
    kopek.havla()

    kedi.sesCikar()
    kedi.yemekYe()
    kedi.miyavla()
}
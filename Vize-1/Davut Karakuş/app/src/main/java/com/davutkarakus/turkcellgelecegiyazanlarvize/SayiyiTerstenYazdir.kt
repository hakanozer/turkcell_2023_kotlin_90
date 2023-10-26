package com.davutkarakus.turkcellgelecegiyazanlarvize

class SayiyiTerstenYazdir() {
    private val sayi = 12345
    init {
        println("Girilen 5 haneli sayi $sayi")
    }
    fun terstenYazdir() {
        val reversed = sayi.toString().reversed()
        println("Sayinin tersten yazilmis hali $reversed")
    }
}
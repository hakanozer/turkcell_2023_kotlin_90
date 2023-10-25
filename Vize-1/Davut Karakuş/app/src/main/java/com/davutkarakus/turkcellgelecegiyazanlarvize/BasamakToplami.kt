package com.davutkarakus.turkcellgelecegiyazanlarvize

class BasamakToplami() {
    private val sayi = 5231
    init {
        println("Girilen 4 haneli sayi $sayi")
    }
    fun basamakToplami() {
            var toplam = 0
            for (s in sayi.toString()) {
                toplam += s.toString().toInt()
            }
            println("Girilen sayinin basamaklari toplami $toplam")
    }
}
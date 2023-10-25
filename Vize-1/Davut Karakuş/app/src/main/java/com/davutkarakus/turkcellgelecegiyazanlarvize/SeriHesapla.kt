package com.davutkarakus.turkcellgelecegiyazanlarvize

class SeriHesapla(private val n:Int) {

    private fun faktoriyelHesapla (sayi:Int) : Long {
        if (sayi == 0) {
            return 1L
        }else {
            var toplam = 1L
            for (i in 1..sayi) {
                toplam *= i
            }
            return toplam
        }
    }

    fun hesapla() {
        if (n < 0) {
            println("Pozitif bir sayi giriniz!")
        }else {
            var sonuc = 1.0
            for (i in 1..n){
                sonuc += (i.toDouble()) / (faktoriyelHesapla(i))
            }
            println("Seri sonucu : $sonuc")
        }
    }
}
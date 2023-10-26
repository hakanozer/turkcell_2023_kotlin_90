package com.works.oopproject._4_Soru

class AsalSayiToplam {
    fun isPrime(sayi: Int) : Boolean {
        if(sayi <= 1) {
            return false
        }

        val bolenAzaltma = (sayi/2) +1
        for(i in 2 until bolenAzaltma ){
            if(sayi % i == 0) {
                return false
            }
        }
        return true
    }

    fun getSumAllPrimes(n: Int) : Int {
        var toplam = 0
        for (i in 1..n) {
            if(isPrime(i)){
                toplam = toplam + i
            }
        }
        return toplam
    }
}
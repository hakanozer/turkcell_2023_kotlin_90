package com.works.oopproject._5_Soru

class AsalMi {
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
}
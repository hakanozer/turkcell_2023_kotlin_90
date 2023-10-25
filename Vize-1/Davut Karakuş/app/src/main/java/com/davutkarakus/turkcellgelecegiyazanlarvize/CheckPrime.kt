package com.davutkarakus.turkcellgelecegiyazanlarvize

class CheckPrime(private val sayi:Int) {

     fun isPrime() : Boolean {
        if (sayi <= 1) {
            return  false
        }else if (sayi == 3 || sayi == 2) {
            return true
        }else if (sayi % 2 == 0 ||sayi % 3 == 0) {
            return false
        }
        var i = 5
        while (i * i <= sayi){
            if (sayi % i == 0 || sayi % (i + 2) == 0) {
                return false
            }
            i += 6
        }
        return true
    }
}
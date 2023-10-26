package com.davutkarakus.turkcellgelecegiyazanlarvize

class AsalSayiToplam(private val n:Int) {

    private fun isPrime(numara:Int) : Boolean {
        if (numara <= 1) {
            return  false
        }
        if(numara <= 3) {
            return true
        }
        if (numara % 2 == 0 || numara % 3 == 0) {
            return false
        }
        var i = 5
        while (i * i <= numara){
            if (numara % i == 0 || numara % (i + 2) == 0) {
                return false
            }
            i += 6
        }
        return true
    }
    fun getSumOfAllPrimes () : Int{
        var toplam = 0
        for (i in 2..n){
            if (isPrime(i)){
                toplam += i
            }
        }
        println("Girilen degere kadar olan asal sayilarin toplami : $toplam")
        return toplam
    }
}
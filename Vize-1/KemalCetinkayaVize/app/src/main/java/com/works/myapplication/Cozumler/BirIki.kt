package com.works.myapplication.Cozumler

class BirIki {


    fun BasamakToplam(sayi: Int): Int {

        val BasTop = sayi / 1000 + (sayi / 100) % 10 + (sayi / 10) % 10 + sayi % 10
        return BasTop

    }

    fun terstenYazdir(sayi: Int): Int {
        val tersten =
            sayi / 10000 + ((sayi / 1000) % 10) * 10 + ((sayi / 100) % 10) * 100 + ((sayi / 10) % 10) * 1000 + (sayi % 10) * 10000
        return tersten

    }

    fun faktorielBolum(number: Int): Double {
        var i: Double = 1.0
        var faktoriyel: Double = 1.0
        var toplamDeger: Double = 0.0
        while (i <= number) {
            toplamDeger += i / faktoriyel
            i++
            faktoriyel *= i
        }
        return toplamDeger
    }
    fun getSumOfAllPrimes(sayi: Int):Int{
        var addition = 0
        var asalMi = true
        for (i in 2 .. sayi+1){

            for ( j in 2 ..i-1){
                if(i%j == 0 ){
                    asalMi = false
                    break
                }
            }
            if(asalMi){
                addition+=i
        }

        }
        return addition



    }

    fun isPrime(sayi:Int):Boolean{
        if(sayi<=1){
            return false
        }
        for ( i in 2 ..sayi-1){
            if(sayi % i == 0 ){
                return false
            }
        }
        return true
    }

}


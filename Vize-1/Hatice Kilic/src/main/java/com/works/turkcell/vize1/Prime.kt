package com.works.turkcell.vize1

class Prime {

    val sayi = 5

    fun isPrime(sayi: Int): Boolean{
        var response = true
        if (sayi >= 2){
            for (i in 2 until sayi){
                if (sayi % i == 0){
                    response = false
                    break
                }
            }
        }else{
            response = false
        }
        return response

    }


}
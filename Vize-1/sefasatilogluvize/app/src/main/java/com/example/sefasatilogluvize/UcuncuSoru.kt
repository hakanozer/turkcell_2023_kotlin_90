package com.example.sefasatilogluvize

class UcuncuSoru(var n:Int) {

    fun faktoriyelHesaplama() {
        if (n <0) -1
        var sayac = 1
        for (i in 1..n) {
            sayac*=i
        }
        if (sayac != 1) {
            println("$n faktöriyel! : $sayac")
        }else {
            println("Negatif sayi!")
        }


    }

}
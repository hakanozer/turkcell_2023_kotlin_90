package com.works.oopproject._1_Soru

class Sayitoplami {
    fun sayiToplam(sayi: Int) : Int {
        if ( sayi in 1000..9999) {
            var toplam = 0
            var number = sayi
            while(number>0) {
                toplam += number %10
                number = number / 10
            }
            return toplam
        }else{
            println("Lütfen 4 haneli sayi giriniz!")
            return 0
        }
    }
}
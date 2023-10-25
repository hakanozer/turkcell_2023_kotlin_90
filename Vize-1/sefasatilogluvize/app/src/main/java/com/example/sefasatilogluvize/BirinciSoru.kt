package com.example.sefasatilogluvize

class BirinciSoru(var sayi:Int) {
    var toplam = 0
    fun hesapla() {

        for (i in sayi.toString()) {

            toplam+=i.toString().toInt()


        }
        println("4 Haneli Saayilarin Toplami: $toplam")

    }


}
package com.bugcompany.vize.Question1

class Question1(var number: Int) {

    fun sumDigit() {
        if (number in 1000..9999) {
            var toplam = 0
            while (number > 0) {
                toplam += number % 10
                number /= 10
            }
            println("Basamakların toplamı: $toplam")
        } else {
            println("Lütfen 4 basamaklı sayı girin")
        }
    }



}






package Soru3

class Soruuc {//Birden n'e kadar olan sayıları toplamamak:
    init {//İlk İşlemi yapacağımı belirttim
        val N = 5//değer verdim
        var toplam = 0//0 almak zorundayım başlangıç değerini

        for (i in 1..N) {
            val kare = i * i
            toplam += kare
            println("$i'Girildi Bunun Karesi:= $kare")
        }

        println("Kareler toplamı: $toplam")
    }
}
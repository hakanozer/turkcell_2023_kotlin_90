package Soru1.`1`

import java.lang.Exception

class Sorubir {

 val sayi = "6565"//dör basamaklı sayı verdim.

    init {//yapılacak ilk işlemi belirtmek için kullandım.
        if (sayi.length == 4) {//String değerdeki karaktere bakıyorum.
            try {
                val sayiInt = sayi.toInt()//Burda String olan ifadeyi geri Int çeviriyorum
                val binler = sayiInt / 1000
                val yuzler = (sayiInt % 1000) / 100
                val onlar = (sayiInt % 100) / 10
                val birler = sayiInt % 10
                val toplam = binler + yuzler + onlar + birler
                println("Belirtilen Sayıların Basamnakları Toplamı=== $toplam")
            } catch (Ex: Exception) {
                println("Geçersiz bir sayı girdiniz.")
            }
        } else {
            println("4 basamaklı bir sayı gereklidir.")
        }
    }
}

package com.gorkemarslanbogan.turkcellkotlinodev1

class Odevler {
    fun UcgenmiKontrol(){
        val doubleArray = DoubleArray(3)
        for (i in doubleArray.indices){
            EkranaYazdir("$i Kenar uzunluğunu girin: ")
            doubleArray[i] = readLine()!!.toDouble()
        }
        val birinciKenar = doubleArray[0]
        val ikinciKenar = doubleArray[1]
        val ucuncuKenar = doubleArray[2]
        if (birinciKenar + ikinciKenar > ucuncuKenar &&
            birinciKenar + ucuncuKenar > ikinciKenar &&
            ikinciKenar + ucuncuKenar > birinciKenar) {
            EkranaYazdir("Bu bir üçgen.")
        } else {
            EkranaYazdir("Bu bir üçgen değil.")
        }
    }

    fun Menu(){
        EkranaYazdir("Menu :")
        EkranaYazdir("1 - F -> C")
        EkranaYazdir("2 - C -> F")
        EkranaYazdir("Secim: ")
        val havaDurumFormulSabiti = 1.8
        val celsiusToFahrenietSabitDeger = 32
        val secim = readLine()?.toIntOrNull()
        if(secim != null){
            when(secim){
                1-> {
                    EkranaYazdir("Fahrenheit değerini giriniz: ")
                    val fahreniet = readLine()?.toDoubleOrNull()
                    if(fahreniet != null){
                        val celcius = (fahreniet - 32) / havaDurumFormulSabiti
                        EkranaYazdir("Hava durumu: $celcius C")
                    }else {
                        EkranaYazdir("Hatalı Giriş")
                    }
                }
                2-> {
                    EkranaYazdir("Celcius değerini giriniz: ")
                    val celcius = readLine()?.toDoubleOrNull()
                    if(celcius != null){
                        val fahreniet = (celcius * havaDurumFormulSabiti) + celsiusToFahrenietSabitDeger
                        EkranaYazdir("Hava durumu: $fahreniet F")
                    }else {
                        EkranaYazdir("Hatalı Giriş")
                    }
                }
                else -> {
                    EkranaYazdir("Hatalı Seçim")
                }
            }
        }
    }


    fun SayilarinToplami(){
        EkranaYazdir("Sayı Girin: ")
        val sayi = readLine()?.toIntOrNull()
        if(sayi != null){
          val toplam =  sayi * (sayi + 1) / 2
            EkranaYazdir("Sayiların Toplamı: $toplam")
        }
    }

    fun SayininRakamlarininToplami(){
        EkranaYazdir("Sayı Girin: ")
        val sayi = readLine()
        if(sayi != null){
            var rakamlarinToplami = 0
            for(element in sayi){
                try {
                    rakamlarinToplami += element.code
                }catch (e:Exception) {
                    e.printStackTrace()
                }
            }
            EkranaYazdir("Rakamların Toplamı: $rakamlarinToplami")
        }
    }


    fun SayiyiTersCevir(){
        EkranaYazdir("Sayı Girin: ")
        val sayi = readLine()

        if (sayi != null && sayi.length == 3 && sayi.toIntOrNull() != null) {
            val tersSayi = sayi.reversed()
            EkranaYazdir("Ters Çevrilmiş Sayı: $tersSayi")
        } else {
            EkranaYazdir("Geçersiz giriş! Lütfen 3 haneli bir sayı girin.")
        }
    }

    fun GirilenSayilarinBilgileri() {
        EkranaYazdir("Sayı Girin: ")
        val sayi = readLine()?.toIntOrNull()
        var pozitifSayilar = 0
        var negatifSayilar = 0
        var ciftSayilar = 0
        var tekSayilar = 0
        var enBuyuk = Int.MIN_VALUE
        var enKucuk = Int.MAX_VALUE
        var toplam = 0
        var ortalama = 0.0

        if (sayi != null && sayi > 0) {
            for (i in 1..sayi) {
                EkranaYazdir("$i. sayıyı girin: ")
                val girilenSayi = readLine()?.toIntOrNull() ?: 0

                if (girilenSayi > enBuyuk) {
                    enBuyuk = girilenSayi
                }

                if (girilenSayi < enKucuk) {
                    enKucuk = girilenSayi
                }

                if (girilenSayi % 2 == 0) {
                    ciftSayilar++
                } else {
                    tekSayilar++
                }

                if (girilenSayi > 0) {
                    pozitifSayilar++
                } else if (girilenSayi < 0) {
                    negatifSayilar++
                }

                toplam += girilenSayi
            }

            ortalama = toplam.toDouble() / sayi.toDouble()

            EkranaYazdir("Girilen $sayi Sayıdan:")
            EkranaYazdir("$pozitifSayilar Tanesi Pozitif")
            EkranaYazdir("$negatifSayilar Tanesi Negatif")
            EkranaYazdir("En Büyüğü : $enBuyuk")
            EkranaYazdir("En Küçüğü : $enKucuk")
            EkranaYazdir("$ciftSayilar Tanesi Çift")
            EkranaYazdir("$tekSayilar Tanesi Tek")
            EkranaYazdir("Toplamları : $toplam")
            EkranaYazdir("Ortalamaları : %.2f".format(ortalama))
        } else {
            EkranaYazdir("Geçersiz giriş! Lütfen geçerli bir pozitif tam sayı girin.")
        }
    }

    fun EkranaYazdir(text: String){
        println(text)
    }

}
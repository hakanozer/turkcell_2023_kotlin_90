package com.example.kotlin_day1._odevler_

fun main(args: Array<String>) {
    //Soru 1 :
    println("Lütfen üçgenin 1. kenar uzunluğunu giriniz:")
    val kenar1 = readLine()!!.toInt()

    println("Lütfen üçgenin 2. kenar uzunluğunu giriniz:")
    val kenar2 = readLine()!!.toInt()

    println("Lütfen üçgenin 3. kenar uzunluğunu giriniz:")
    val kenar3 = readLine()!!.toInt()

    isTriangle(kenar1, kenar2, kenar3)

    //Soru 2:
    println("Menu:")
    println("1 - Fahrenheit'dan Celsius'a dönüşüm için seçiniz")
    println("2 - Celsius'tan Fahrenheit'a dönüşüm için seçiniz")
    print("Seçim: ")

    val secim = readLine()!!.toInt()

    when (secim) {
        1 -> {
            println("Fahrenheit değerini giriniz: ")
            val fahrenheit = readLine()!!.toDouble()
            val celsius = fahrenheitToCelsius(fahrenheit)
            println("$fahrenheit F = $celsius C")
        }

        2 -> {
            println("Celsius değerini giriniz: ")
            val celsius = readLine()!!.toDouble()
            val fahrenheit = celsiusToFahrenheit(celsius)
            println("$celsius C = $fahrenheit F")
        }

        else -> {
            println("Hatalı seçim! Lütfen 1 veya 2 seçiniz.")
        }
    }

    //Soru 3:

    println("Lütfen ilk sayıyı giriniz:")
    val sayi1 = readLine()?.toInt()

    println("Lütfen ikinci sayıyı giriniz:")
    val sayi2 = readLine()?.toInt()

    if (sayi1 != null && sayi2 != null) {
        if (sayi1 > sayi2) {
            println("$sayi1 büyük, $sayi2 küçük")
        } else if (sayi2 > sayi1) {
            println("$sayi2 büyük, $sayi1 küçük")
        } else {
            println("Sayılar eşittir")
        }
    }

    //Soru 4:

    println("Lütfen bir N sayısı giriniz:")
    val n = readLine()?.toInt()
    if (n != null) {
        val toplam = (n * (n + 1)) / 2
        println("1'den $n'e kadar olan sayıların toplamı: $toplam")
    }

    //Soru 5:

    println("3 haneli bir sayı giriniz:")
    val sayi = readLine()!!.toInt()

    if (sayi in 100..999) {
        val birlerBasamagi = sayi % 10
        val onlarBasamagi = (sayi / 10) % 10
        val yuzlerBasamagi = (sayi / 100) % 10

        val toplam = birlerBasamagi + onlarBasamagi + yuzlerBasamagi

        println("$yuzlerBasamagi + $onlarBasamagi + $birlerBasamagi = $toplam")
    } else {
        println("Hatalı giriş! Lütfen 3 haneli bir sayı giriniz.")
    }

    //Soru 6:
    println("3 haneli bir sayı girin: ")
    val sayiTers = readLine()!!.toInt()

    if (sayi in 100..999) {
        val birlerBasamagi = sayiTers % 10
        val onlarBasamagi = (sayiTers / 10) % 10
        val yuzlerBasamagi = (sayiTers / 100) % 10

        val tersSayi = birlerBasamagi * 100 + onlarBasamagi * 10 + yuzlerBasamagi

        println("Tersten yazılmış hali: $tersSayi")
    } else {
        println("Hatalı giriş! Lütfen 3 haneli bir sayı giriniz.")
    }

    //Soru 7:
    println("Lütfen kaç sayı gireceğinizi giriniz")
    val nm = readLine()!!.toInt()

    println("Lütfen $nm tane sayı giriniz")
    val sayilar = Array(nm) { readLine()!!.toInt() }


    val pozitifSayiSayisi = sayilar.count { it > 0 }
    val negatifSayiSayisi = sayilar.count { it < 0 }
    val enBuyukSayi = sayilar.maxOrNull()!!
    val enKucukSayi = sayilar.minOrNull()!!
    val ciftSayiSayisi = sayilar.count { it % 2 == 0 }
    val tekSayiSayisi = sayilar.count { it % 2 != 0 }
    val toplam = sayilar.sum()
    val ortalama = toplam / nm

    println(
        """
        Girilen $nm sayıdan:
        Pozitif sayı sayısı: $pozitifSayiSayisi
        Negatif sayı sayısı: $negatifSayiSayisi
        En büyük sayı: $enBuyukSayi
        En küçük sayı: $enKucukSayi
        Çift sayı sayısı: $ciftSayiSayisi
        Tek sayı sayısı: $tekSayiSayisi
        Toplamları: $toplam
        Ortalamaları: $ortalama
    """.trimIndent()
    )
}


//Soru 1 :
fun isTriangle(a: Int, b: Int, c: Int) {

    if ((a + b >= c) && (a + c >= b) && (b + c >= a)) {
        println("Üçgen yapıldı")
    } else {
        println("Üçgen yapılamadı")
    }
}

//Soru 2 :

fun fahrenheitToCelsius(fahrenheit: Double): Double {
    return (fahrenheit - 32) * 5 / 9
}

fun celsiusToFahrenheit(celsius: Double): Double {
    return (celsius * 9 / 5) + 32
}

package com.example.odev1

import java.util.Scanner

fun main(args: Array<String>) {

    println("-----1------")
    val scanner = Scanner(System.`in`)
    println("1. kenari giriniz")
    val k1 = scanner.nextInt()

    println("ikinci kenari giriniz:")
    val k2 = scanner.nextInt()

    println("ucuncu kenari giriniz:")
    val k3 = scanner.nextInt()

    if(k1<k2+k3 && k2<k1+k3 && k3<k1+k2){
        println("Ucgen olusturulabilir")
    }
    else{
        println("ucgen cizilemez")
    }

    println("-----2------")

    println("Menu :\n" + "\t1 - F -> C\n" + "\t2 - C -> F\n")


    println("Secim :")
    val option = scanner.nextInt()

    println("secim = $option")
    if (option != null && (option == 1 || option == 2)) {
        println("sicakligi giriniz:")
        val temperature = scanner.nextDouble()

        if (temperature != null) {
            when (option) {
                1 -> {
                    val celsius = fahrenheitToCelsius(temperature)
                    println( "$temperature F = $celsius C")

                }
                2 -> {
                    val fahrenheit = celsiusToFahrenheit(temperature)
                    println("$temperature C = $fahrenheit F" )
                }
            }
        } else {
            println("gecersiz deger girdiniz.")
        }
    } else {
        println("Lutfen 1 veya 2 yi seciniz")
    }

    println("-----3------")


    println("1. sayiyi giriniz")
    val s1 = scanner.nextInt()

    println("2. sayiyi giriniz:")
    val s2 = scanner.nextInt()

    if (s1 > s2){
        println("buyuk olan sayi = $s1 \n kucuk olan sayi = $s2")
    }else if (s2 > s1){
        println("buyuk olan sayi = $s2 \n kucuk olan sayi = $s1")
    }else
        println("Sayilar esittir")


    println("-----4------")

    println("Bir N sayisi giriniz ")
    val n = scanner.nextInt()

    if (n >= 0){
        val sonuc = n * (n+1)/2
        println("1 den $n e kadar sayilarin toplami = $sonuc")
    }else{
        println("lutfen degerleri kontrol ediniz")
    }

    println("-----5------")

    var toplam = 0
    println("3 basamakli bir sayi giriniz")
    var sayi = scanner.nextInt()

    do {
        val rakam = sayi % 10
        toplam += rakam
        sayi /= 10
    }while (sayi > 0)

    println("basamaklar toplami = $toplam")

    println("-----6------")

    var reverse = 0
    println("3 basamakli bir sayi giriniz")
    var sayi1 = scanner.nextInt()

    do {
        reverse *= 10
        reverse += sayi1 % 10
        sayi1 = sayi1/10
    }while (sayi1 != 0)

    println("girilen sayinin tersi = $reverse")

    println("-----7------")


    var pozitifAdet = 0
    var negatifAdet = 0
    var enBuyuk = 0
    var enKucuk = 0
    var  toplamm = 0
    var tekAdet = 0
    var ciftAdet = 0
    var ortalama = 0.0


    println("Kac adet sayi gireceksiniz?")
    var adet = scanner.nextInt()

    for (i in 1..adet){
        println("$i . sayiyi giriniz: ")
        var sayii = scanner.nextInt()

        if (sayii > 0){
            pozitifAdet += 1
        }else if (sayii < 0){
            negatifAdet += 1
        }


        if (i == 1){
            enBuyuk = sayii
            enKucuk = sayii
        }else{
            if (sayii >= enBuyuk){
                enBuyuk = sayii
            }
            if (sayii < enKucuk) {
                enKucuk = sayii
            }
        }

        if (sayii % 2 == 0){
            ciftAdet++
        }else tekAdet++

        toplamm += sayii
        ortalama = toplamm.toDouble() / n
        

    }

    println("Girilen $adet sayidan : \n")
    println("$pozitifAdet tanesi pozitif \n" +
            "$negatifAdet tanesi negatif \n" +
            "En buyugu : $enBuyuk \n" +
            "En kucugu : $enKucuk \n" +
            "$ciftAdet tanesi cift \n" +
            "$tekAdet tanesi tek \n" +
            "Toplamlari : $toplamm \n" +
            "Ortalamalari : $ortalama")
}
fun celsiusToFahrenheit(celsius: Double): Double {
    return (celsius * 9 / 5) + 32
}

fun fahrenheitToCelsius(fahrenheit: Double): Double {
    return (fahrenheit - 32) * 5 / 9
}


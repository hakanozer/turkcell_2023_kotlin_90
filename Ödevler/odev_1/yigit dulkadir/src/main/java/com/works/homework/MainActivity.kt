package com.works.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.accessibility.AccessibilityViewCommand.SetProgressArguments

fun main(args: Array<String>){


    /*  soru 1*/
    println("1. kenar uzunluğunu :")
    val kenar1 = readLine()?.toDoubleOrNull()

    println("2. kenar uzunluğunu :")
    val kenar2 = readLine()?.toDoubleOrNull()

    println("3. kenar uzunluğunu :")
    val kenar3 = readLine()?.toDoubleOrNull()

    if (kenar1 == null || kenar2 == null || kenar3 == null) {
        println("Geçerli bir değer giriniz!")
        return
    }
    else if(kenar1 +kenar2 < kenar3){
        println("üçgen olmaz ")
    }
    else {
        println("üçgen olur ")
    }



    /* soru 2 */
    println("Menu :")
    println("1 - F -> C")
    println("2 - C -> F")
    print("Secim: ")

    val secim = readLine()?.toIntOrNull()

    when (secim) {
        1 -> {
            println("Fahrenheit  ?:")
            val fahrenheit = readLine()?.toDoubleOrNull()
            if (fahrenheit != null) {
                val celsius = (fahrenheit - 32) * 5/9
                println("$fahrenheit F = $celsius C")
            } else {
                println("Geçerli bir Fahrenheit  giriniz.")
            }
        }
        2 -> {
            println("Celsius  giriniz:")
            val celsius = readLine()?.toDoubleOrNull()
            if (celsius != null) {
                val fahrenheit = (celsius * 9/5) + 32
                println("$celsius C = $fahrenheit F")
            } else {
                println("Geçerli bir Celsius  giriniz.")
            }
        }
        else -> {
            println("Hatalı seçim!")
        }
    }



    /* soru 3*/
    println("Birinci sayıyı giriniz:")
    val sayi1 = readLine()?.toIntOrNull()

    println("İkinci sayıyı giriniz:")
    val sayi2 = readLine()?.toIntOrNull()

    if (sayi1 == null || sayi2 == null) {
        println("Geçerli bir sayı giriniz!")
        return
    }

    when {
        sayi1 > sayi2 -> println("$sayi1, $sayi2'den büyüktür.")
        sayi1 < sayi2 -> println("$sayi2, $sayi1'den büyüktür.")
        else -> println("Sayılar eşittir.")
    }



    /*  soru 4*/
    println("Lütfen  N sayısı girinz:")
    val n = readLine()?.toIntOrNull()

    if (n == null) {
        println("Geçerli  sayı giriniz!")
        return
    }
    val toplam = n * (n + 1) / 2
    println("1'den $n'e kadar olan sayıların toplamı: $toplam")

    /* soru 5 */
    println("3 haneli bir sayı girin:")
    val numbers = readLine()?.toIntOrNull()

    if (numbers == null || numbers < 100 || numbers > 999) {
        println("Lütfen geçerli 3 haneli  sayı girin!")
        return
    }

    val birler = numbers % 10
    val onlar = (numbers / 10) % 10
    val yuzler = numbers / 100

    val toplams = birler + onlar + yuzler

    println("$yuzler + $onlar + $birler = $toplams")




         // soru 6//
    println("3 haneli  sayı girin:")
    val sayi = readLine()?.toIntOrNull()

    if (sayi == null || sayi < 100 || sayi > 999) {
        println("Lütfen  3 haneli  sayı girin!")
        return
    }

    val tersSayi = sayi.toString().reversed()
    println(tersSayi)



    // soru 7//

    println("Kaç sayı gireceksiniz?")
    val f = readLine()?.toIntOrNull()

    if (f == null || f <= 0) {
        println("Geçerli  sayı giriniz.")
        return
    }

    var pozitifSayi = 0
    var negatifSayi = 0
    var ciftSayi = 0
    var tekSayi = 0
    var toplamlar = 0
    var enBuyuk: Int? = null
    var enKucuk: Int? = null

    for (i in 1..f) {
        println("$i. sayıyı giriniz:")
        val sayi = readLine()?.toIntOrNull()

        if (sayi == null) {
            println("Geçerli  sayı giriniz.")
            return
        }

        // Pozitif-Negatif Kontrolü
        if (sayi > 0) pozitifSayi++
        if (sayi < 0) negatifSayi++

        // Çift-Tek Kontrolü
        if (sayi % 2 == 0) ciftSayi++
        else tekSayi++

        // En Büyük-En Küçük Kontrolü
        enBuyuk = enBuyuk?.let { if (sayi > it) sayi else it } ?: sayi
        enKucuk = enKucuk?.let { if (sayi < it) sayi else it } ?: sayi

        toplamlar += sayi
    }

    val ortalama = toplamlar.toDouble() / f

    println("Girilen $f Sayıdan:")
    println("$pozitifSayi tanesi pozitif")
    println("$negatifSayi tanesi negatif")
    println("En büyüğü: $enBuyuk")
    println("En küçüğü: $enKucuk")
    println("$ciftSayi tanesi çift")
    println("$tekSayi tanesi tek")
    println("Toplamları: $toplamlar")
    println("Ortalamaları: $ortalama")





}


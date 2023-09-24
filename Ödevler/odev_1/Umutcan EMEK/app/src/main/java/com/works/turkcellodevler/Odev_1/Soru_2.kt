package com.works.turkcellodevler.Odev_1

import java.util.Scanner

/*
2 - Kullanıcıya Aşağıdaki Menuyu Gösteriyorsunuz

Menu :
1 - F -> C
2 - C -> F
Secim :

Kullanıcı 1'i Seçerse Fahrenheit Değerini Alıyorsunuz
Girilen Değeri Dereceye Çevirip
x F = y C Şeklinde Ekranda Gösteriyorsunuz

Eğer 2. Seçenek Seçildiyse, C Değerini Alıyorsunuz
Girilen Değeri Fahrenheit'a Çevirip
x C = y F Şeklinde Ekranda Gösteriyorsunuz

Eğer Kullanıcı Menu Seceneginde 1,2 Dışında Bir Sayı
Girerse Ekrana Hatalı Seçim Mesajını Bastırmalısınız
*/

fun main(args: Array<String>) {

    println("Seçenekler:\n 1 - F -> C\n 2 - C -> F")

    print("Seçiminizi belirtiniz: ")
    val scanner = Scanner(System.`in`)
    val secim = scanner.nextInt()

    print("Dönüştürmek istediğiniz değeri giriniz: ")
    val scanner2 = Scanner(System.`in`)
    val deger = scanner2.nextFloat()

    when (secim) {
        1 -> {
            val sonuc = (deger-32)/1.8
            println("$deger F = $sonuc C")
        }
        2 -> {
            val sonuc = deger*1.8 + 32
            println("$deger C = $sonuc F")
        }
        else -> {
            println("Lütfen mevcut seçeneklerden birini seçtiğinizi kontrol ediniz.")
        }
    }

}
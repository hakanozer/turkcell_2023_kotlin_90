package com.tutkuzdmr.odev1

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


fun main(args: Array<String>){

    val scanner = Scanner(System.`in`)

    println("Menu : ")
    println("1 - F -> C")
    println("2 - C -> F")
    println("Secim :")

    val secim = scanner.nextInt()

    when (secim) {
        1 -> fahrenheitToCelsius()
        2 -> celsiusToFahrenheit()
        else -> println("Hatali secim yaptiniz.")
    }
}

fun fahrenheitToCelsius() {
    println("Fahrenheit degeri girin:")
    val fahrenheit = readLine()!!.toDouble()
    val celsius = (fahrenheit - 32) * 5 / 9
    println("$fahrenheit Fahrenheit = $celsius Celsius")
}

fun celsiusToFahrenheit() {
    println("Celsius degeri girin:")
    val celsius = readLine()!!.toDouble()
    val fahrenheit = (celsius * 9 / 5) + 32
    println("$celsius Celsius = $fahrenheit Fahrenheit")
}

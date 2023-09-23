package com.example.challenge01.Question2

import java.lang.Exception


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

    println(" 1 - F -> C \n 2 - C -> F ")
    println("------------")

    try {
        println("Please a make choice")
        val selection = readln()

        println("Enter a temperature value")
        val sicaklik = readln().toDouble()
        (convert(selection, sicaklik))
    } catch (e: Exception) {
        println("Valid choice or temperature")

    }


}


fun convert(selection: String, sicaklik: Double) {

    when (selection) {
        "1" -> convertToCelsius(sicaklik)
        "2" -> convertToFahrenheit(sicaklik)
        else -> {
            println("Valid selection")
        }

    }

}

fun convertToCelsius(fahrenheit: Double) {
    //°C = (°F – 32) / 1.8
    val celsius = (fahrenheit - 32) / 1.8
    println("$fahrenheit °F = $celsius °C")

}

fun convertToFahrenheit(celsius: Double) {
    //°F = °C × 1.8 + 32
    val fahrenheit = celsius * 1.8 + 32
    println("$celsius °C = $fahrenheit °F")
}

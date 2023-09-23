package com.example.challenge01.Question6

import java.lang.Exception

/*
6 - Kullanıcıdan 3 Haneli Bir Sayı
	Alıyorsunuz. Bu Sayının
	Rakamlarını Tersten Yazdırıyorsunuz
	Örnek :
	Sayı Girin : 743
	347
 */


fun main(args: Array<String>) {
    try {
        println("Enter a number")
        val number = readln()
        if ((number.length == 3)) {
            println(reverseNumber(number.toInt()))
        } else {
            println("Please enter a 3 digit number.")
        }
    } catch (e: Exception) {
        println("Please enter a number")
    }
}

fun reverseNumber(number: Int): String {
    val onesDigit = number % 10
    val tensDigit = (number % 100) / 10
    val hundredsDigit = number / 100

    val result = "$onesDigit$tensDigit$hundredsDigit"
    return result

}

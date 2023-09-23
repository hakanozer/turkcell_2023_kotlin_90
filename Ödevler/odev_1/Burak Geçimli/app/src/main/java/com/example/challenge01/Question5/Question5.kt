package com.example.challenge01.Question5

import java.lang.Exception

/*
5 - Kullanıcıdan 3 Haneli Bir Sayı
	Alıyorsunuz. Bu Sayının
	Basamaklarının Toplamını
	Yazdırıyorsunuz

	Örnek :
	Sayı Girin : 245
	2 + 4 + 5 = 11

 */

fun main(args: Array<String>) {

    try {
        println("Enter a number")
        val number = readln()
        if ((number.length == 3)) {
            println(sumDigit(number.toInt()))
        } else {
            println("Please enter a 3 digit number.")
        }
    } catch (e: Exception) {
        println("Please enter a number")
    }


}

fun sumDigit(number: Int): String {
    //789 -> 7*100 + 8*10 + 9*1
    val onesDigit = number % 10
    val tensDigit = (number % 100) / 10
    val hundredsDigit = number / 100

    val sum = onesDigit + tensDigit + hundredsDigit
    val result = "$hundredsDigit + $tensDigit + $onesDigit =$sum"
    return result

}


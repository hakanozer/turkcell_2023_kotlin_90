package com.example.challenge01.Question3


/*
3 - Kullanıcıdan 2 Sayı Alıyorsunuz
	Bu 2 Büyük ve Küçük Olanını Ekrana Bastırıyorsunuz
	Eğer Sayılar Eşitse Sayılar Eşittir Mesajını
	Ekrana Bastırıyorsunuz
 */
fun main(args: Array<String>) {

    try {
        println("Enter first number")
        val firstNumber = readlnOrNull()?.toInt()

        println("Enter second number")
        val secondNumber = readlnOrNull()?.toInt()

        if (firstNumber != null && secondNumber != null) {
            makeControlNumbers(firstNumber, secondNumber)
        }
    } catch (e: Exception) {
        println("İnvalid or empty value!")
    }

}

fun makeControlNumbers(firstNumber: Int, secondNumber: Int) {

    if (firstNumber > secondNumber) {
        println("Large Number:$firstNumber Small Number:$secondNumber")
    } else if (firstNumber < secondNumber) {
        println("Large Number:$secondNumber Small Number:$firstNumber")
    } else {
        println("Numbers are Equals")
    }

}

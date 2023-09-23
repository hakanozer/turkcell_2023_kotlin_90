package com.example.challenge01.Question1

import java.lang.Exception
import java.util.Scanner

/*
    1 - Kullanıcıdan 3 Kenar Değeri Alıyorsun
    Bu 3 Değerden Üçgen Yapılıp Yapılamayacağını
    Test Edip Sonucu Bastıracaksınız

    Her 2 Kenarın Toplamı Diğer 3. Kenara Eşit/Fazlaysa
    Üçgen Olur
 */
fun main(args: Array<String>) {

    try {
        println("Enter the first edge")
        val firstEdge = readln().toInt()

        println("Enter the second edge")
        val secondEdge = readln().toInt()

        println("Enter the third edge")
        val thirdEdge = readln().toInt()

        val result = if (isTriangle(firstEdge, secondEdge, thirdEdge)) {
            "This is Triangle"
        } else {
            "This is not Triangle"
        }
        println(result)

    } catch (e: Exception) {
        println("You entered an incorrect or empty value")
    }


}

fun isTriangle(firstEdge: Int, secondEdge: Int, thirdEdge: Int): Boolean {

    val isOkFirstEdge = (secondEdge + thirdEdge) >= firstEdge
    val isOkSecondEdge = (firstEdge + thirdEdge) >= secondEdge
    val isThirdEdge = (firstEdge + secondEdge) >= thirdEdge

    val result = isOkFirstEdge && isOkSecondEdge && isThirdEdge
    return result


}
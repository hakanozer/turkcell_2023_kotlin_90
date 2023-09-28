package com.works.turkcell.q5

import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Lutfen 3 basamakli bir sayi giriniz ")
    val number = scanner.nextInt()

    val sayi = total(number)
    println("Girilen sayidaki rakamlarin toplami: $sayi")
}
fun total(number: Int): Int {
    var sum = 0
    var remainingNumber = number

    while (remainingNumber > 0){
        val num =remainingNumber % 10
        sum += num
        remainingNumber /= 10

    }
    return sum
}





package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
22-Mükemmel sayıları bulan bir try-catch algoritması yazınız.(Furkan Akı)
 */

fun main(args: Array<String>) {

    try {
        print("Bir sayı giriniz: ")
        val scanner = Scanner(System.`in`)
        val num = scanner.nextInt()

        if (num != null && num > 0) {
            if (isPerfectNumber(num)) {
                println("$num bir mükemmel sayıdır.")
            } else {
                println("$num bir mükemmel sayı değildir.")
            }
        } else {
            println("Lütfen pozitif bir tam sayı girin.")
        }
    }catch (ex: Exception){
        println("Girdiğiniz değerin bir sayı olduğundan emin olunuz.")
    }
    }


fun isPerfectNumber(num: Int): Boolean {
    var sum = 0
    for (i in 1 until num) {
        if (num % i == 0) {
            sum += i
        }
    }
    return sum == num
}
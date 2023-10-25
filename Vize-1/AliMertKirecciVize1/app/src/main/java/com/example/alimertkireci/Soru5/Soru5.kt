package Soru5

import java.util.Scanner

fun main(args: Array<String>) {
    val actionObj=Inheritance()
    val scanner = Scanner(System.`in`)



    print("Bir sayı girin: ")
    val sayi = scanner.nextInt()

    val asalMi = actionObj.isPrime(sayi)

    if (asalMi) {
        println("$sayi asal bir sayıdır.")
    } else {
        println("$sayi asal bir sayı değildir.")
    }
}
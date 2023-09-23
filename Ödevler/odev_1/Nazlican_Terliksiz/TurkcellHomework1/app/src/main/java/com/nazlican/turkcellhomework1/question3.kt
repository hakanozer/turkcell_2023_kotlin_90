package com.nazlican.turkcellhomework1

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("Birinci sayıyı giriniz: ")
    val sayi1 = scanner.nextInt()

    print("Ikinci sayıyı giriniz: ")
    val sayi2 = scanner.nextInt()

    val buyuk = if (sayi1 > sayi2) sayi1 else sayi2
    val kucuk = if (sayi1 < sayi2) sayi1 else sayi2

    println("$buyuk büyük, $kucuk küçük")

    if (sayi1 == sayi2) {
        println("Sayılar eşittir.")
    }
}
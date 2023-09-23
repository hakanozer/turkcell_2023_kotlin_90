package com.nazlican.turkcellhomework1

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("3 haneli bir sayı giriniz: ")
    val sayi = scanner.nextInt()

    val birlerBasamagi = sayi % 10
    val onlarBasamagi = (sayi / 10) % 10
    val yuzlerBasamagi = sayi / 100

    val tersSayi = birlerBasamagi * 100 + onlarBasamagi * 10 + yuzlerBasamagi

    println("Tersten yazılan sayı: $tersSayi")
}
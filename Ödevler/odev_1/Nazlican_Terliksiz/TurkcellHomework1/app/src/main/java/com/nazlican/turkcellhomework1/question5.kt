package com.nazlican.turkcellhomework1

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("3 haneli bir sayı giriniz: ")
    val sayi = scanner.nextInt()

    val birlerBasamagi = sayi % 10
    val onlarBasamagi = (sayi / 10) % 10
    val yuzlerBasamagi = (sayi / 100) % 10

    val toplam = birlerBasamagi + onlarBasamagi + yuzlerBasamagi

    println("$yuzlerBasamagi + $onlarBasamagi + $birlerBasamagi = $toplam")
}

package com.nazlican.turkcellhomework1

import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)

    print("Bir N sayısı giriniz: ")
    val n = scanner.nextInt()

    val toplam = (n * (n + 1)) / 2

    println("1'den $n'e kadar olan sayıların toplamı: $toplam")
}
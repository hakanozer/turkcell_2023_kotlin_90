package com.nazlican.turkcellhomework1

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Menu:")
    println("1 - F -> C")
    println("2 - C -> F")
    print("Seçim: ")

    val secim = scanner.nextInt()

    when (secim) {
        1 -> {
            print("Fahrenheit değerini giriniz: ")
            val fahrenheit = scanner.nextDouble()
            val celsius = (fahrenheit - 32) * 5 / 9
            println("$fahrenheit F = $celsius C")
        }
        2 -> {
            print("Celsius değerini giriniz: ")
            val celsius = scanner.nextDouble()
            val fahrenheit = (celsius * 9 / 5) + 32
            println("$celsius C = $fahrenheit F")
        }
        else -> {
            println("Hatalı seçim. Lütfen 1 veya 2 giriniz.")
        }
    }
}
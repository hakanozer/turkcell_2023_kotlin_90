package com.work_turkcell._odev_1

fun main(args: Array<String>){
    println("Menu: ")
    println("1 - F -> C")
    println("2 - C -> F")
    print("  Secim:")
    val secim = readLine()
    when (secim) {
        "1" -> {
            println("Fahrenheit değerini girin: ")
            val f = readLine()?.toDoubleOrNull()
            if (f != null) {
                val c = (f - 32) * 5 / 9
                println("$f F = $c C")
            } else {
                println("Bir sayı giriniz")
            }
        }
        "2" -> {
            println("Celsius değerini girin: ")
            val c = readLine()?.toDoubleOrNull()
            if (c != null) {
                val f = (c * 9 / 5) + 32
                println("$c C = $f F")
            } else {
                println("Bir sayı giriniz")
            }
        }
        else -> {
            println("1 veya 2'yi seçiniz")
        }
    }
}
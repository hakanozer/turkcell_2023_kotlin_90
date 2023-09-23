package com.nazlican.turkcellhomework1

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Üçgen oluşturmak için kenar uzunluklarını giriniz:")
    print("Birinci kenar: ")
    val kenar1 = scanner.nextInt()

    print("İkinci kenar: ")
    val kenar2 = scanner.nextInt()

    print("Üçüncü kenar: ")
    val kenar3 = scanner.nextInt()

    if (ucgen(kenar1, kenar2, kenar3)) {
        println("üçgen oluşturabilirsiniz.")
    } else {
        println("üçgen oluşturamazsınız.")
    }
}

fun ucgen(a: Int, b: Int, c: Int): Boolean {
    return (a + b > c) && (a + c > b) && (b + c > a)
}
package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.Scanner

//Parametre olarak aldığı sayıyı
//asal mı diye kontrol edip,
//sayı asal ise true, değilse false döndüren
//isPrime methodunu yazın
//
//public static boolean isPrime(int n)

fun main() {
    val scanner = Scanner(System.`in`)
    var sayi: Int

    print("Bir sayi giriniz: ")
    sayi = scanner.nextInt()

    val isPrimeResult = isPrime(sayi)

    if (isPrimeResult)
        println("Sayi Asaldir")
    else
        println("Sayi Asal Degildir")
}
fun isPrime(n: Int): Boolean {
    if (n <= 1) {
        return false
    }

    if (n <= 3) {
        return true
    }

    if (n % 2 == 0 || n % 3 == 0) {
        return false
    }

    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) {
            return false
        }
        i += 6
    }

    return true
}
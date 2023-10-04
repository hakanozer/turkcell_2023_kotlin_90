package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.Scanner

//Kullanıcıdan iki değer alan ve bu değerlerin ortalamasını hesaplayıp
//ekrana bastıran bir metod yazın.Eğer girilen inputlardan birisi integer
//değilse "Lütfen integer değerler giriniz." diye uyarı ekrana bastırsın ve method
//input almaya baştan başlasın.

fun main() {
    val scanner = Scanner(System.`in`)
    var sayi1: Int
    var sayi2: Int

    do {
        try {
            print("Birinci sayıyı giriniz: ")
            sayi1 = scanner.nextInt()

            print("İkinci sayıyı giriniz: ")
            sayi2 = scanner.nextInt()

            val ortalama = (sayi1 + sayi2).toDouble() / 2
            println("Girilen sayıların ortalaması: $ortalama")
        } catch (e: java.util.InputMismatchException) {
            println("Hata: Lütfen integer değerler giriniz.")
            scanner.nextLine()
            continue
        }
        break
    } while (true)
}





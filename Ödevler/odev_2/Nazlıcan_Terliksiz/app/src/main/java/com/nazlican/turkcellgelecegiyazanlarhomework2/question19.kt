package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.*

// Kullanıcıdan dört basamaklı bir sayı alınız.
//Alınan sayının 2 ile bölümünden kalanın sıfır olup olmadığını
//try-catch ile kontrol eden bir program yazınız.

fun main() {
    val scanner = Scanner(System.`in`)
    var sayi: Int

    try {
        print("Dört basamaklı bir sayı giriniz: ")
        sayi = scanner.nextInt()

        if (sayi < 1000 || sayi > 9999) {
            throw IllegalArgumentException("Dört basamaklı bir sayı girmelisiniz.")
        }

        if (sayi % 2 == 0) {
            println("$sayi, 2'ye bölümünden kalan sıfırdır.")
        } else {
            println("$sayi, 2'ye bölümünden kalan sıfır değildir.")
        }
    } catch (e: InputMismatchException) {
        println("Hata: Geçerli bir sayı girişi yapmadınız.")
    } catch (e: IllegalArgumentException) {
        println("Hata: $e")
    }
}
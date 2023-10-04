package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.Scanner

//Girilen 2 String ifadenin  karakter sayılarını karşıllaştıran ve eşit değilse
//"Karakter sayıları uyuşmuyor"
// uyarısı veren Try-catch alıştırması yapınız.

fun main() {
    val scanner = Scanner(System.`in`)
    var str1: String
    var str2: String

    do {
        try {
            print("İlk string ifadeyi giriniz: ")
            str1 = scanner.nextLine()

            print("İkinci string ifadeyi giriniz: ")
            str2 = scanner.nextLine()

            if (str1.length != str2.length) {
                throw IllegalArgumentException("Karakter sayıları uyuşmuyor.")
            } else {
                println("Girilen ifadeler karakter sayıları açısından uyuşuyor.")
            }
        } catch (e: IllegalArgumentException) {
            println("Hata: ${e.message}")
            continue
        }
        break
    } while (true)
}
package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.*

//Bir kullanıcıdan alınan metin verisini tamsayıya
//dönüştüren bir kotlin prgoramı yazınız.

fun main() {
    val scanner = Scanner(System.`in`)
    var metin: String

    try {
        print("Bir tamsayı giriniz: ")
        metin = scanner.nextLine()

        val tamsayi = metin.toInt()
        println("Girilen tamsayı: $tamsayi")
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir tamsayı girişi yapmadınız.")
    }
}
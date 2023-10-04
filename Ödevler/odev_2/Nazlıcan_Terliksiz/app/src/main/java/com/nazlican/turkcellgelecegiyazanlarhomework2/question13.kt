package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.Scanner

// kullanıcıdan bir sayi alan ve bu sayıyı ekrana gösteren bir değer alın girilen değerin sayı olup olmadığını
//try-cath ile kontrol edip hata yönetimini sağlayın. (Görkem Arslanboğan)

fun main() {
    val scanner = Scanner(System.`in`)
    var sayi: Int = 0

    try {
        print("Bir sayı giriniz: ")
        val girilenDeger = scanner.nextLine()
        sayi = girilenDeger.toInt()
        println("Girilen sayı: $sayi")
    } catch (e: NumberFormatException) {
        println("Hata: Geçersiz bir sayı girişi yapıldı.")
    }
}






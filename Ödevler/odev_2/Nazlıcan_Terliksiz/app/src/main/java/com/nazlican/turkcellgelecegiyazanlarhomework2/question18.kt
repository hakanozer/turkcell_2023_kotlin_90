package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.*

//Kullanıcıdan alınan 2 verinin çarpımını bulan bir program yazınız.
//Verilerin integer olmaması durumunu try-catch
//bloğu ile kontrol ediniz.

fun main() {
    val scanner = Scanner(System.`in`)
    var sayi1: String
    var sayi2: String

    try {
        print("Birinci sayıyı giriniz: ")
        sayi1 = scanner.nextLine()

        print("İkinci sayıyı giriniz: ")
        sayi2 = scanner.nextLine()

        // Girişleri integer'a çevirip çarpma işlemi yapma
        val sonuc = sayi1.toInt() * sayi2.toInt()
        println("Sonuç: $sonuc")
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli iki tamsayı girişi yapmadınız.")
    }
}
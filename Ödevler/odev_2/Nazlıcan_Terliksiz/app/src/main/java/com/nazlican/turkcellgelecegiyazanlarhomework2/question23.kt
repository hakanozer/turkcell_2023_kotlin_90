package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.*

// Try catch kullanarak kullanıcının girdiği bir
//sayının karekökünü hesaplayan program yazınız.
//Negatif sayı girilmediğinden emin olunuz

fun main() {
    val scanner = Scanner(System.`in`)

    try {
        print("Bir sayı girin: ")
        val sayi = scanner.nextDouble()

        if (sayi < 0) {
            throw IllegalArgumentException("Negatif sayı girişi yapamazsınız.")
        }

        val karekok = hesaplaKarekok(sayi)
        println("Girdiğiniz sayının karekökü: $karekok")
    } catch (e: InputMismatchException) {
        println("Hata: Geçerli bir sayı girişi yapmadınız.")
    } catch (e: IllegalArgumentException) {
        println("Hata: ${e.message}")
    }
}

fun hesaplaKarekok(sayi: Double): Double {
    return Math.sqrt(sayi)
}
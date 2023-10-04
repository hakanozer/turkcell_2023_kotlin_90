package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.InputMismatchException
import java.util.Scanner

//Mükemmel sayıları bulan bir try-catch algoritması yazınız

fun main() {
    val scanner = Scanner(System.`in`)
    try {
        print("Bir üst sınırı girin: ")
        val ustSinir = scanner.nextInt()

        if (ustSinir < 1) {
            throw IllegalArgumentException("Geçerli bir üst sınır girin (1 veya daha büyük).")
        }

        println("Mükemmel sayılar:")
        for (sayi in 1..ustSinir) {
            if (isMukemmelSayi(sayi)) {
                println(sayi)
            }
        }
    } catch (e: InputMismatchException) {
        println("Hata: Geçerli bir tamsayı girişi yapmadınız.")
    } catch (e: IllegalArgumentException) {
        println("Hata: ${e.message}")
    }
}

fun isMukemmelSayi(sayi: Int): Boolean {
    var toplam = 0
    for (bolen in 1 until sayi) {
        if (sayi % bolen == 0) {
            toplam += bolen
        }
    }
    return toplam == sayi
}
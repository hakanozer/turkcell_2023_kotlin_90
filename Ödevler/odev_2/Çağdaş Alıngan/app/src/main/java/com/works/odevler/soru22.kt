package com.works.odevler

import java.util.Scanner

/**
 *22-Mükemmel sayıları bulan bir try-catch algoritması yazınız.(Furkan Akı)
 */
fun main(args: Array<String>) {


       val scanner = Scanner(System.`in`)
        try {
            print("Bir sayı girin: ")
            val sayi = scanner.nextInt()

            if (sayi <= 0) {
                println("Geçersiz giriş! Pozitif bir sayı girin.")
                return
            }

            val toplamBolenler = toplamBolenleriBul(sayi)

            if (toplamBolenler == sayi) {
                println("$sayi bir mükemmel sayıdır.")
            } else {
                println("$sayi bir mükemmel sayı değildir.")
            }
        } catch (e: Exception) {
            println("Geçersiz giriş! Bir tam sayı girin.")
        } finally {
            println("Orjinal soruymuş Furkan , uğraştırdı.")
        }




}

fun toplamBolenleriBul(sayi: Int): Int {
    var toplam = 0
    for (item in 1 until sayi) {
        if (sayi % item == 0) {
            toplam += item
        }
    }
    return toplam
}
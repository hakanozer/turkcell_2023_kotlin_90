package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.InputMismatchException
import java.util.Scanner

//Kullanıcıdan pozitif bir tam sayı alınız ve
//bu sayının faktöriyelini hesaplayınız. Kullanıcı metin veya
//negatif bir tam sayı girişi yaptığında try-catch ile hata mesajları görüntüleyiniz

fun main() {
    val scanner = Scanner(System.`in`)

    try {
        print("Pozitif bir tam sayı girin: ")
        val sayi = scanner.nextInt()

        if (sayi < 0) {
            throw IllegalArgumentException("Negatif bir sayı girişi yapamazsınız.")
        }

        val faktoriyel = faktoriyelHesapla(sayi)
        println("$sayi'nin faktöriyeli: $faktoriyel")
    } catch (e: InputMismatchException) {
        println("Hata: Geçerli bir tam sayı girişi yapmadınız.")
    } catch (e: IllegalArgumentException) {
        println("Hata: ${e.message}")
    }
}

fun faktoriyelHesapla(sayi: Int): Long {
    var faktoriyel: Long = 1
    for (i in 1..sayi) {
        faktoriyel *= i.toLong()
    }
    return faktoriyel
}
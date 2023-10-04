package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.*

//kullanıcıdan ,0 ile 20 arasından 5 sayı seçin sayıların tek mi çift mi olduğunu bulunuz,
//Bulduğunuz sayıların tek ve çift olanların aritmetik ortalamasını ayrı ayrı bulunuz,
//Try Catch İle Doğrulayın

fun main() {
    val scanner = Scanner(System.`in`)
    val sayilar = mutableListOf<Int>()

    try {
        for (i in 1..5) {
            val sayi = alSayi(scanner, i)
            sayilar.add(sayi)
        }

        val (tekSayilar, ciftSayilar) = sayilariAyir(sayilar)
        val tekOrtalama = ortalamaHesapla(tekSayilar)
        val ciftOrtalama = ortalamaHesapla(ciftSayilar)

        println("Girilen Tek Sayılar: $tekSayilar")
        println("Tek Sayıların Aritmetik Ortalaması: $tekOrtalama")
        println("Girilen Çift Sayılar: $ciftSayilar")
        println("Çift Sayıların Aritmetik Ortalaması: $ciftOrtalama")
    } catch (e: InputMismatchException) {
        println("Hata: Geçerli bir sayı girişi yapmadınız.")
    } catch (e: IllegalArgumentException) {
        println("Hata: ${e.message}")
    }
}

fun alSayi(scanner: Scanner, index: Int): Int {
    print("0 ile 20 arasında bir sayı girin ($index/5): ")
    val sayi = scanner.nextInt()

    if (sayi < 0 || sayi > 20) {
        throw IllegalArgumentException("Geçersiz aralıkta bir sayı girdiniz. 0 ile 20 arasında olmalıdır.")
    }

    return sayi
}

fun sayilariAyir(sayilar: List<Int>): Pair<List<Int>, List<Int>> {
    val tekSayilar = sayilar.filter { it % 2 == 1 }
    val ciftSayilar = sayilar.filter { it % 2 == 0 }
    return Pair(tekSayilar, ciftSayilar)
}

fun ortalamaHesapla(sayilar: List<Int>): Double {
    return if (sayilar.isNotEmpty()) {
        sayilar.average()
    } else {
        0.0
    }
}
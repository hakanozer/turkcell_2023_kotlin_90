package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.InputMismatchException
import java.util.Scanner

//Kullanıcıdan 3 basamaklı sayılar isteyiniz
//ve bu sayılardan armstrong sayısı bulan bir algoritma
//olusturunuz ve verilerin sayı girilmesini de Try catch
//yapısı ile kontrolünü sağlayınız

fun main() {
    val scanner = Scanner(System.`in`)

    try {
        print("1. 3 basamaklı sayıyı girin: ")
        val sayi1 = scanner.nextInt()

        print("2. 3 basamaklı sayıyı girin: ")
        val sayi2 = scanner.nextInt()

        print("3. 3 basamaklı sayıyı girin: ")
        val sayi3 = scanner.nextInt()

        val armstrongSayilar = mutableListOf<Int>()

        if (sayiGecerliMi(sayi1) && sayiGecerliMi(sayi2) && sayiGecerliMi(sayi3)) {
            if (isArmstrongSayi(sayi1)) {
                armstrongSayilar.add(sayi1)
            }
            if (isArmstrongSayi(sayi2)) {
                armstrongSayilar.add(sayi2)
            }
            if (isArmstrongSayi(sayi3)) {
                armstrongSayilar.add(sayi3)
            }

            if (armstrongSayilar.isEmpty()) {
                println("Girilen sayılardan Armstrong sayısı yok.")
            } else {
                println("Girilen Armstrong sayıları: $armstrongSayilar")
            }
        } else {
            throw IllegalArgumentException("Geçerli 3 basamaklı sayılar giriniz.")
        }

    } catch (e: InputMismatchException) {
        println("Hata: Geçerli bir sayı girişi yapmadınız.")
    } catch (e: IllegalArgumentException) {
        println("Hata: ${e.message}")
    }
}

fun sayiGecerliMi(sayi: Int): Boolean {
    return sayi in 100..999
}

fun isArmstrongSayi(sayi: Int): Boolean {
    var toplam = 0
    var geciciSayi = sayi

    while (geciciSayi != 0) {
        val basamak = geciciSayi % 10
        toplam += basamak * basamak * basamak
        geciciSayi /= 10
    }

    return toplam == sayi
}
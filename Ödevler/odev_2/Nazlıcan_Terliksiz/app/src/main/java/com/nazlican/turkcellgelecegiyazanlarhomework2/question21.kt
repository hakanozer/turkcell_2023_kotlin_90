package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.InputMismatchException
import java.util.Scanner

//Kullanıcıdan bir listenin boyutunu ve elemanlarını tamsayılar
//ile doldurmasını isteyin.Geçersiz boyut ve eleman girişini
//Try-catch yapısı ile kontrol edin.Ve listenin çift indeksteki ve tek indeksteki
//tamsayıların toplamını yazdırın

fun main() {
    val scanner = Scanner(System.`in`)

    try {
        print("Liste boyutunu girin: ")
        val boyut = scanner.nextInt()

        if (boyut <= 0) {
            throw IllegalArgumentException("Geçersiz liste boyutu. Pozitif bir tamsayı girilmelidir.")
        }

        val liste = IntArray(boyut)

        for (i in 0 until boyut) {
            print("Liste elemanını girin ($i/$boyut): ")
            liste[i] = scanner.nextInt()
        }

        val (tekToplam, ciftToplam) = indekslereGoreToplamHesapla(liste)
        println("Çift İndeksli Elemanların Toplamı: $ciftToplam")
        println("Tek İndeksli Elemanların Toplamı: $tekToplam")

    } catch (e: InputMismatchException) {
        println("Hata: Geçerli bir tamsayı girişi yapmadınız.")
    } catch (e: IllegalArgumentException) {
        println("Hata: ${e.message}")
    }
}

fun indekslereGoreToplamHesapla(liste: IntArray): Pair<Int, Int> {
    var tekToplam = 0
    var ciftToplam = 0

    for (i in liste.indices) {
        if (i % 2 == 0) {
            // Çift indeksli elemanları topla
            ciftToplam += liste[i]
        } else {
            // Tek indeksli elemanları topla
            tekToplam += liste[i]
        }
    }

    return Pair(tekToplam, ciftToplam)
}
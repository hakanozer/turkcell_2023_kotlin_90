package com.works.odevler

import java.util.Scanner

/**
 *21- Kullanıcıdan bir listenin boyutunu ve elemanlarını tamsayılar
 * ile doldurmasını isteyin.Geçersiz boyut ve eleman girişini
 * Try-catch yapısı ile kontrol edin.Ve listenin çift indeksteki ve tek indeksteki
 * tamsayıların toplamını yazdırın.(Burak Geçimli)
 */
fun main(args: Array<String>) {
    try {

        val scanner = Scanner(System.`in`)
        val liste = mutableListOf<Int>()


        println("kaç elemanlı liste oluşturmak istiyorsunuz")
        val n = scanner.nextInt()


        for (item in 1..n) {

            println("Tam sayı giriniz !")
            val sayi = scanner.nextInt()
            liste.add(sayi)
        }

        var tekToplam = 0
        var ciftToplam = 0

        for (item in liste.indices){
            if (item %2 == 0){
                tekToplam += liste[item]
            }else{
                ciftToplam += liste[item]
            }
        }

        println("Tek indeksli elemanların toplamı: $tekToplam")
        println("Çift indeksli elemanların toplamı: $ciftToplam")

    }catch (ex:Exception){
        println("Lütfen tam sayı giriniz")
    }

}
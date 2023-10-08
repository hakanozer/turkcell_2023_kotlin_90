package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
21- Kullanıcıdan bir listenin boyutunu ve elemanlarını tamsayılar
ile doldurmasını isteyin.Geçersiz boyut ve eleman girişini
Try-catch yapısı ile kontrol edin.Ve listenin çift indeksteki ve tek indeksteki
tamsayıların toplamını yazdırın.(Burak Geçimli)
 */

fun main(args: Array<String>) {

    var num: Int
    try {
        print("Kaç elamanlı bir sayı listesi oluşturmak istiyorunuz: ")
        val scanner = Scanner(System.`in`)
        val sizeArr = scanner.nextInt()
        println("Listenin elamanlarını giriniz: ")
        val array = mutableListOf<Any>()
        for (i in 1..sizeArr) {
            print("$i. Sayı: ")
            val scanner = Scanner(System.`in`)
            num = scanner.nextInt()
            array.add(num)
        }
        println("Girdiğiniz sayılar: $array")
    } catch (ex: Exception) {
        println("İlgili bölümlere yalnızca sayı girdiğinizden emin olunuz.")
    }

}






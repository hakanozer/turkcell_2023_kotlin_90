package com.works.odevler._1_odev

import java.util.Scanner
/*
4 - Kullanıcıdan Bir N Sayısı Alıyorsunuz
	1'den N'e Kadar Olan Sayıların Toplamını
	Ekrana Bastırıyorsunuz (Formulü Araştırın)
 */
fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    println("Sayı Giriniz!")
    val N = scanner.nextInt()

    var toplam = 0

    for (i in 1..N) {
        toplam += i
    }

    println("1'den N'e kadar olan sayıların toplamı: $toplam")

}
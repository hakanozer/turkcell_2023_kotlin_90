package com.example.sefasatilogluodev_1

import java.util.Scanner

/*
4 - Kullanıcıdan Bir N Sayısı Alıyorsunuz
	1'den N'e Kadar Olan Sayıların Toplamını
	Ekrana Bastırıyorsunuz (Formulü Araştırın)
 */


fun main() {

    val girdi = Scanner(System.`in`)
    print("Lütfen sayi giriniz:")
    val num1 = girdi.nextInt()
    var total = 0
    for (i in 1..num1) {
        total+=i
    }
    println("1'den $num1'e kadar sayilarin toplami : $total")

}
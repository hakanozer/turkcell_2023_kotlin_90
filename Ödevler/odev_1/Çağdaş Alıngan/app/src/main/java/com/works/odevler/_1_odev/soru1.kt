package com.works.odevler._1_odev

import java.util.Scanner

// 1. SORU
/*
1 - Kullanıcıdan 3 Kenar Değeri Alıyorsun
Bu 3 Değerden Üçgen Yapılıp Yapılamayacağını
Test Edip Sonucu Bastıracaksınız

Her 2 Kenarın Toplamı Diğer 3. Kenara Eşit/Fazlaysa
Üçgen Olur
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("1. Kenar Değerini Giriniz!")
    val n1 = scanner.nextInt()
    println("2. Kenar Değerini Giriniz!")
    val n2 = scanner.nextInt()
    println("3. Kenar Değerini Giriniz!")
    val n3 = scanner.nextInt()

    val toplam = n1 + n2 >= n3 && n2 + n3 >= n1 && n1 + n3 >= n2

    println("$n1 , $n2 , $n3")

    if (toplam){
        println("üçgen olur!")

    }else {
        println("üçgen olmaz")
    }

}


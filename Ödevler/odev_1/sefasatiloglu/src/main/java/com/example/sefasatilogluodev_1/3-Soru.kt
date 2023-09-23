package com.example.sefasatilogluodev_1

import java.util.Scanner

/*
3 - Kullanıcıdan 2 Sayı Alıyorsunuz
Bu 2 Büyük ve Küçük Olanını Ekrana Bastırıyorsunuz
Eğer Sayılar Eşitse Sayılar Eşittir Mesajını
Ekrana Bastırıyorsunuz
 */
fun main() {

    val girdi = Scanner(System.`in`)
    println("Birinci Sayiyi Giriniz:")
    val num1 = girdi.nextInt()
    println("Ikinci Sayiyi Giriniz:")
    val num2 = girdi.nextInt()

    if (num1 > num2) {
        println("Büyük sayi: $num1 ")
        println("Kücük Sayi: $num2")
    }else if(num2 > num1) {
        println("Büyük sayi: $num2")
        println("Kücük sayi: $num1")
    }else {
        println("$num1 ve $num2 sayisi birbirine eşittir")
    }




}
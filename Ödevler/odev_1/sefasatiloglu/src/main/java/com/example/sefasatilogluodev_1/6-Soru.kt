package com.example.sefasatilogluodev_1

import java.util.Scanner

/*
6 - Kullanıcıdan 3 Haneli Bir Sayı
	Alıyorsunuz. Bu Sayının
	Rakamlarını Tersten Yazdırıyorsunuz
	Örnek :
	Sayı Girin : 743
	347
 */

fun main() {

    val girdi = Scanner(System.`in`)
    println("Lütfen sayi giriniz:")
    val num1 = girdi.next()
    val reversedNum1 = num1.reversed().toInt()
    println("Sayının Tersi: $reversedNum1")


}
package com.example.sefasatilogluodev_1

import java.lang.NumberFormatException
import java.util.Scanner

/*
5 - Kullanıcıdan 3 Haneli Bir Sayı
	Alıyorsunuz. Bu Sayının
	Basamaklarının Toplamını
	Yazdırıyorsunuz

	Örnek :
	Sayı Girin : 245
	2 + 4 + 5 = 11
 */

fun main() {
    try {
        val girdi = Scanner(System.`in`)
        println("Lütfen sayi giriniz")
        val sayi = girdi.next()
        if (sayi.length != 3) {
            println("Lutfen 3 Basamakli Sayi Giriniz.")
        }else {
            var toplam = 0
            for (i in sayi) {
                toplam +=i.toString().toInt()
            }
            println("Toplam: $toplam")

        }

    }catch (e:NumberFormatException) {
        println("Lütfen Sadece rakam giriniz!")
    }





}
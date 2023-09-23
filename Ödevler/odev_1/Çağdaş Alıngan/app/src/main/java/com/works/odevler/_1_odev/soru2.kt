package com.works.odevler._1_odev

import java.util.Scanner

/*
2 - Kullanıcıya Aşağıdaki Menuyu Gösteriyorsunuz

	Menu :
	1 - F -> C
	2 - C -> F
	    Secim :

	Kullanıcı 1'i Seçerse Fahrenheit Değerini Alıyorsunuz
	Girilen Değeri Dereceye Çevirip
	x F = y C Şeklinde Ekranda Gösteriyorsunuz

	Eğer 2. Seçenek Seçildiyse, C Değerini Alıyorsunuz
	Girilen Değeri Fahrenheit'a Çevirip
	x C = y F Şeklinde Ekranda Gösteriyorsunuz

	Eğer Kullanıcı Menu Seceneginde 1,2 Dışında Bir Sayı
	Girerse Ekrana Hatalı Seçim Mesajını Bastırmalısınız
 */

fun main(args: Array<String>) {


       val scanner = Scanner(System.`in`)
       println(
           "Menu :\n" +
                   "\t1 - F -> C\n" +
                   "\t2 - C -> F\n" + " 1 ve ya 2 'yi seçiniz"
       )

       val secim1 = scanner.nextInt()

        if (secim1 == 1) {

            println("Fahrenheit Değerini giriniz !")
            val F = scanner.nextInt()
            val toplam = (F - 32) / 1.8
            println("$F F = $toplam C")
        } else if (secim1 == 2) {
            println("Celcius Değerini giriniz !")
            val C = scanner.nextInt()
            val toplam = C * 1.8 + 32
            println("$C C = $toplam F")
        }else{
            println("lütfen belirtilen değerler arasından birini seçin!")
        }

   }

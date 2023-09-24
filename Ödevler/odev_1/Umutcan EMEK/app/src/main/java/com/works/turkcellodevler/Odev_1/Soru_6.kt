package com.works.turkcellodevler.Odev_1

import java.util.Scanner

/*
6 - Kullanıcıdan 3 Haneli Bir Sayı
	Alıyorsunuz. Bu Sayının
	Rakamlarını Tersten Yazdırıyorsunuz
	Örnek :
	Sayı Girin : 743
	347
 */

fun main(args: Array<String>) {

    print("Bir sayı giriniz: ")
    val scanner = Scanner(System.`in`)
    var num = scanner.nextInt()

    if (num < 0){
        num = -num
    }

    print("Sayının terse çevrilmiş hali: ")

    while (num > 0){
        val reverse = num % 10
        num = num / 10
        print(reverse)
    }

}
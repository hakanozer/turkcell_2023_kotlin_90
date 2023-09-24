package com.works.turkcellodevler.Odev_1

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

fun main(args: Array<String>) {

    print("Bir sayı giriniz: ")
    val scanner = Scanner(System.`in`)
    var num = scanner.nextInt()

    if (num < 0){
        num = -num
    }

    var sum = 0
    while (num>0){
        val remain = num % 10
        num = num / 10
        sum += remain

    }

    println("Girdiğiniz sayının basamaklarının toplamı = $sum")

}
package com.works.odevler._1_odev

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
    val scanner = Scanner(System.`in`)
    println("Sayı giriniz :  ")
    var N = scanner.nextInt()

    var total: Int = 0

    while (N > 0 ) {
        total += N % 10
        N /= 10
    }
    println(total)

}
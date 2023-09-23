package com.works.odevler._1_odev

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
    val scanner = Scanner(System.`in`)
    println("Sayı giriniz : ")
    var N = scanner.nextInt()

    var tersCevir = 0

    while(N != 0)
    {
        tersCevir *= 10;
        tersCevir += N % 10;
        N /= 10;
    }
    println("Ters çevrilen sayı \n$tersCevir")
}
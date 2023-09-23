package com.works.odevler._1_odev

import java.util.Scanner
/*
3 - Kullanıcıdan 2 Sayı Alıyorsunuz
	Bu 2 Büyük ve Küçük Olanını Ekrana Bastırıyorsunuz
	Eğer Sayılar Eşitse Sayılar Eşittir Mesajını
	Ekrana Bastırıyorsunuz
 */
fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    println("Sayı Giriniz!")
    val n1 = scanner.nextInt()
    println("Sayı Giriniz!")
    val n2 = scanner.nextInt()

    val deger = n1 > n2
    val deger1 = n2 > n1

    if (deger){
        println("$n1 > $n2")
    }else if (deger1){
        println("$n2 > $n1")
    }else println("Sayılar Eşittir")

}
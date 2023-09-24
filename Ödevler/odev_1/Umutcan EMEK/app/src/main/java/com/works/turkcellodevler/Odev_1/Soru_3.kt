package com.works.turkcellodevler.Odev_1

import java.util.Scanner

/*
3 - Kullanıcıdan 2 Sayı Alıyorsunuz
	Bu 2 Büyük ve Küçük Olanını Ekrana Bastırıyorsunuz
	Eğer Sayılar Eşitse Sayılar Eşittir Mesajını
	Ekrana Bastırıyorsunuz
 */

fun main(args: Array<String>) {

    print("İlk sayıyı giriniz: ")
    val scanner = Scanner(System.`in`)
    val num1 = scanner.nextInt()

    print("İkinci sayıyı giriniz: ")
    val scanner2 = Scanner(System.`in`)
    val num2 = scanner2.nextInt()

    if (num1 > num2){
        println("Büyük olan sayı: $num1\nKüçük olan sayı: $num2")
    }else if (num1 < num2){
        println("Büyük olan sayı: $num2\nKüçük olan sayı: $num1")
    }else{
        println("Sayılar eşittir.")
    }

}
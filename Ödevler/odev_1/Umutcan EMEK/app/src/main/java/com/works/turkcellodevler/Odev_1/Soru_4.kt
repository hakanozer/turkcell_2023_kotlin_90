package com.works.turkcellodevler.Odev_1

import java.util.Scanner

/*
4 - Kullanıcıdan Bir N Sayısı Alıyorsunuz
	1'den N'e Kadar Olan Sayıların Toplamını
	Ekrana Bastırıyorsunuz (Formulü Araştırın)
 */

fun main(args: Array<String>) {

    print("Bir sayı giriniz: ")
    val scanner =  Scanner(System.`in`)
    val num = scanner.nextInt()
    val sonuc = num*(num + 1) / 2
    println("1'den $num'a kadar olan sayıların toplamı = $sonuc")

}
package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
16-Girilen 2 String ifadenin  karakter sayılarını karşıllaştıran ve eşit değilse
"Karakter sayıları uyuşmuyor"
 uyarısı veren Try-catch alıştırması yapınız.(Çağdaş Alıngan)
 */

fun main(args: Array<String>) {

    // Bu sorunun try-catch gerektirdiğini düşünmüyorum.

    print("Birinci string ifadeyi giriniz: ")
    val scanner = Scanner(System.`in`)
    val str1 = scanner.nextLine()
    print("İkinci string ifadeyi giriniz: ")
    val scanner2 = Scanner(System.`in`)
    val str2 = scanner2.nextLine()

    if (str1.length != str2.length) {
        println("Karakter sayıları uyuşmuyor.")
    } else {
        println("Karakter sayıları uyuşuyor.")
    }

}
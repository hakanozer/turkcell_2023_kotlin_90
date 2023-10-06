package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
12 - bir sayıyı sıfıra bölmeye çalışırken karşılaşılan bir hata durumunu ele almak için nasıl bir try-catch bloğu oluşturursunuz?
(Sefa Satiloglu)
 */

fun main(args: Array<String>) {

    print("Bölünen sayıyı giriniz: ")
    val scanner = Scanner(System.`in`)
    val num1 = scanner.nextInt()
    print("Bölen sayıyı giriniz: ")
    val scanner2 = Scanner(System.`in`)
    val num2 = scanner2.nextInt()

    try {
        var result: Double = num1.toDouble() / num2.toDouble()
        println("Sonuç: $result")
    }catch (ex:Exception){
        println("Lütfen ilgili bölümlere sayı ve bölen sayı kısmına 0 girmediğinizi kontrol ediniz.")
    }

}
package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
19- Kullanıcıdan dört basamaklı bir sayı alınız.
Alınan sayının 2 ile bölümünden kalanın sıfır olup olmadığını
try-catch ile kontrol eden bir program yazınız.(Hatice Kılıç)
 */

fun main(args: Array<String>) {

    try {
        print("Dört basamaklı bir sayı giriniz: ")
        val scanner = Scanner(System.`in`)
        val num = scanner.nextInt()

        if (num in 1000..9999) {
            if (num % 2 == 0) {
                println("Sayının 2'ye bölümünden kalan 0'dır.")
            } else {
                println("Sayı 2'ye tam bölünemiyor")
            }
        } else {
            println("Lütfen dört basamaklı bir sayı giriniz.")
        }
    } catch (ex: Exception) {
        println("Girdiğiniz değerin bir sayı olduğundan emin olunuz.")
    }
}

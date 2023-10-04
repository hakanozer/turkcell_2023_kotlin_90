package com.works.odevler

import java.util.Scanner

/**
 * 19- Kullanıcıdan dört basamaklı bir sayı alınız.
 * Alınan sayının 2 ile bölümünden kalanın sıfır olup olmadığını
 * try-catch ile kontrol eden bir program yazınız.(Hatice Kılıç)
 */

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("sayi giriniz")
    try {
        val sayi = scanner.nextInt()
        if ( sayi.toString().length == 4 && sayi%2==0) {
            println("sayi 4 basamaklı ve çift")
        } else if (sayi.toString().length == 4 && sayi%2==1){
            println("sayi 4 basamaklı ve tek")
        }else{
            println("Lütfen 4 basamaklı sayı giriniz ")
        }
    }catch (ex:Exception){
        println("Lütfen tamsayı giriniz")
    }


}
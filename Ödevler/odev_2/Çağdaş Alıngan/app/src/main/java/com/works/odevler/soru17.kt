package com.works.odevler

import java.util.Scanner

/**
 * 17- Bir kullanıcıdan alınan metin verisini tamsayıya
 * dönüştüren bir kotlin prgoramı yazınız. (Keremcan Karakaya)
 */

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Metin giriniz")
    val str = scanner.nextLine()

    try {
        val sayi = str.toInt()
        println(sayi)
    }catch (ex:Exception){
        println("Lütfen tam sayi girin!!")
    }

}
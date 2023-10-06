package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
18- Kullanıcıdan alınan 2 verinin çarpımını bulan bir program yazınız.
Verilerin integer olmaması durumunu try-catch
bloğu ile kontrol ediniz. (Davut Karakuş)
 */

fun main(args: Array<String>) {

    println("Çarpmak şstediğiniz sayıları giriniz:")
    try {
        print("Birinci Sayı: ")
        val scanner = Scanner(System.`in`)
        val num1 = scanner.nextInt()
        print("İkinci Sayı: ")
        val scanner2 = Scanner(System.`in`)
        val num2 = scanner2.nextInt()

        val result = num1 * num2
        println("Girdiğiniz iki sayının çarpımı: $result")
    }catch (ex: Exception){
        println("İlgili alanlara sadece sayı girilebilir!")
    }




}
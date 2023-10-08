package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
15- Kullanıcıdan iki değer alan ve bu değerlerin ortalamasını hesaplayıp
ekrana bastıran bir metod yazın.Eğer girilen inputlardan birisi integer
değilse "Lütfen integer değerler giriniz." diye uyarı ekrana bastırsın ve method
input almaya baştan başlasın. (Çağatay Çınar Lökçe)
 */

fun main(args: Array<String>) {

    try {
        print("Birinci sayıyı giriniz: ")
        val scanner = Scanner(System.`in`)
        val num1 = scanner.nextInt()
        print("İkinci sayıyı giriniz: ")
        val scanner2 = Scanner(System.`in`)
        val num2 = scanner2.nextInt()

        var result: Double = (num1.toDouble() + num2.toDouble()) / 2
        println("Sonuç: $result")
    }catch (ex:Exception){
        println("Lütfen ilgili bölümlere sayı ve bölen sayı kısmına 0 girmediğinizi kontrol ediniz.")
    }


}
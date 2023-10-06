package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
20-kullanıcıdan ,0 ile 20 arasından 5 sayı seçin sayıların tek mi çift mi olduğunu bulunuz,
Bulduğunuz sayıların tek ve çift olanların aritmetik ortalamasını ayrı ayrı bulunuz,
Try Catch İle Doğrulayın.(Ali Mert Kireçci)
 */

fun main(args: Array<String>) {

    try {
        println("0-20 aralığında 5 adet sayı giriniz.")
        val arr = mutableListOf<Int>()
        for (i in 1..5){
            print("$i. Sayı: ")
            val scanner = Scanner(System.`in`)
            val num = scanner.nextInt()
            arr.add(num)
        }
        val oddNum = arr.filter { it % 2 == 1 }
        val evenNum = arr.filter { it % 2 == 0 }
        println("Tek sayılar: $oddNum")
        println("Çift sayılar: $evenNum")

        val averageOdd = oddNum.average()
        val averageEven = evenNum.average()

        println("\nTek sayıların ortalaması: $averageOdd")
        println("Çift sayıların ortalaması: $averageEven")
    }catch (ex: Exception){
        println("İlgilili alanlara sadece sayısal değerler giriniz.")
    }

}


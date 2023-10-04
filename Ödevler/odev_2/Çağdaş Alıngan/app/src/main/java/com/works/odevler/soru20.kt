package com.works.odevler

import java.util.Scanner

/**
 * 20-kullanıcıdan ,0 ile 20 arasından 5 sayı seçin sayıların tek mi çift mi olduğunu bulunuz,
 * Bulduğunuz sayıların tek ve çift olanların aritmetik ortalamasını ayrı ayrı bulunuz,
 * Try Catch İle Doğrulayın.(Ali Mert Kireçci)
 */
fun main(args: Array<String>) {

    try {

        val sayilar = mutableListOf<Int>()
        val tekSayilar = mutableListOf<Int>()
        val ciftSayilar = mutableListOf<Int>()


        for (item in 1..5) {
            val scanner = Scanner(System.`in`)
            println("0 ile 20 arasından 5 sayı seçin  : ")
            val sayi = scanner.nextInt()
            sayilar.add(sayi)

        }

        for (tek in sayilar){
            if (tek %2 == 1){
                tekSayilar.add(tek)
            }
        }
        for (cift in sayilar){
            if (cift %2 == 0){
                ciftSayilar.add(cift)
            }
        }
        val tek = tekSayilar.size
        val cift = ciftSayilar.size
        val tekOrt = tekSayilar.sum().toDouble()/tek
        val ciftOrt = ciftSayilar.sum().toDouble()/cift





        println("Teksayı ortalaması : $tekOrt , Çift sayı ortalaması : $ciftOrt")
        println("tek sayılar : $tek")
        println("çift sayılar : $cift")
    }catch (ex:Exception){
        println("Lütfen tam sayı giriniz")
    }



}
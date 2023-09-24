package com.works.turkcellodevler.Odev_1

import java.util.Scanner

/*
7 -	Kullanıcıdan Kac Sayi Girecegini Ogren (N)
    Kullanıcıdan N Tane Sayı Al

    Sayı Girişi Bittikten Sonra Aşağıdakine Benzer Bir Rapor Olustur
    Girilen 17 Sayıdan :
    8 Tanesi Pozitif
    6 Tanesi Negatif
    En Büyüğü : 67
    En Küçüğü : -9
    10 Tanesi Çift
    7 Tanesi Tek
    Toplamları : 567
    Ortalamaları : 33,345
 */

fun main(args: Array<String>) {

    print("Kaç adet sayı gireceksiniz: ")
    val scanner = Scanner(System.`in`)
    val pieceNum = scanner.nextInt()
    val numList = arrayListOf<Int>()

    var positiveCount = 0
    var negativeCount = 0
    var notrCount = 0
    var bigNum = 0
    var smallNum = 0
    var oddCount = 0
    var evenCount = 0
    var sum = 0
    var average= 0.0

    for (i in 1..pieceNum){
        print("$i. sayıyı giriniz:")
        val scanner = Scanner(System.`in`)
        val num = scanner.nextInt()
        numList.add(num)

        if (num < 0){
            negativeCount++
        }else if (num > 0){
            positiveCount++
        }else
            notrCount++

        if (num > bigNum || smallNum == 0){
            bigNum = num
        }
        if (num < smallNum || smallNum == 0){
            smallNum = num
        }

        if (num % 2 == 1){
            oddCount++
        }else
            evenCount++

        sum += num

    }

    average = sum.toDouble() / pieceNum

    println("Girilen Sayılar: ${numList}")

    println("Girilen $pieceNum sayıdan:\n" +
            "$positiveCount Tanesi Pozitif\n" +
            "$negativeCount Tanesi Negatif\n" +
            "$notrCount Tanesi Nötr\n" +
            "En Büyüğü: $bigNum\n" +
            "En Küçüğü: $smallNum\n" +
            "$oddCount Tanesi Tek\n" +
            "$evenCount Tanesi Çift\n" +
            "Toplamları: $sum\n" +
            "Ortalamaları: $average")

}
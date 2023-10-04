package com.work_turkcell._odev_1

fun main(args: Array<String>) {
    var pozitif = 0
    var negatif = 0
    var Buyuk = Int.MIN_VALUE
    var Kucuk = Int.MAX_VALUE
    var cift = 0
    var tek = 0
    var toplam = 0

    println("Kaç sayı gireceksiniz?")
    val N = readLine()!!.toInt()
    println("$N sayı giriniz")

    for (i in 1..N) {
        print("$i. sayıyı girin: ")
        val N = readLine()!!.toInt()
        toplam = toplam + N
        if (N > 0) {
            pozitif++
        } else if (N < 0) {
            negatif++
        }
        if (N % 2 == 0) {
            cift++
        } else {
            tek++
        }
        if (N > Buyuk){
            Buyuk = N
        }
        if (N < Kucuk){
            Kucuk = N
        }
    }
    val ortalama = toplam.toDouble() / N

    println("Girilen $N Sayıdan:")
    println("$pozitif Tanesi Pozitif")
    println("$negatif Tanesi Negatif")
    println("En Büyüğü: $Buyuk")
    println("En Küçüğü: $Kucuk")
    println("$cift Tanesi Çift")
    println("$tek Tanesi Tek")
    println("Toplamları: $toplam")
    println("Ortalamaları: $ortalama")

}
package com.works.odevler._1_odev
import android.annotation.SuppressLint
import java.util.Scanner
import kotlin.math.max

/*Kullanıcıdan Kac Sayi Girecegini Ogren (N)
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
Ortalamaları : 33,345*/




@SuppressLint("SuspiciousIndentation")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Kaç sayı gireceksiniz : ")
    val N = scanner.nextInt()

    val sayilar = mutableListOf<Int>()


    for (item in 1..N) {

        println("Sayı girin : ")
        val sayi = scanner.nextInt()
        sayilar.add(sayi)

    }


    val pozitif = sayilar.count { it > 0 }
    val negatif = sayilar.count { it < 0 }
    val buyuk = sayilar.maxOrNull()
    val kucuk = sayilar.minOrNull()
    val cift = sayilar.count { it % 2 == 0 }
    val tek = sayilar.count { it % 2 != 0 }
    val toplam = sayilar.sum()
    val ortalama: Double = toplam.toDouble()/N



    println("Girilen $N sayıdan; \n$pozitif pozitif,\n$negatif negatif,\n$buyuk buyuk, \n$kucuk kucuk," +
            " \n$cift çift, \n$tek tek,  \nsayıların toplamı:$toplam, \nortalama:$ortalama")


}





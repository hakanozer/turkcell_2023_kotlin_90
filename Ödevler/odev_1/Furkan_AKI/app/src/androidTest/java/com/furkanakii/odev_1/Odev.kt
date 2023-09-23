package com.furkanakii.odev_1

import java.util.Scanner

fun main() {
    println("Geleceği Yazanlar Ödev Sistemine Hoş Geldiniz")
    println("Ödevler")
    println("1- Üçgen sorusu")
    println("2- Celsius && Fahrenheit")
    println("3- Kullanıcıdan 2 sayı alınan soru")
    println("4- N Toplamı sorusu")
    println("5- 3 Haneli sayı sorusu")
    println("6- Rakamları ters yazdırma sorusu")
    println("7- Son Soru")

    println("Lütfen bir 0 ve 8 arasında bir ödev seçiniz")
    val sc = Scanner(System.`in`)
    val soru = sc.nextInt()

    if (soru == 1) {
        println("3 adet sayı giriniz")
        var a = sc.nextInt()
        var b = sc.nextInt()
        var c = sc.nextInt()
        var x = a + b
        var y = a + c
        var z = b + c

        if (x <= c && y <= b && z <= a) {

            println("Üçgen çizilebilir")
        } else {
            println("çizilemez")
        }

    } else if (soru == 2) {
        println("Menü")
        println("1 - F -> C")
        println("2 - C -> F")
        println("Yapmak istediğiniz işlemi seçin")
        var secim = sc.nextInt()

        if (secim == 1) {
            println("Fahreneit değerini girin")
            var f: Double = sc.nextDouble()
            var c: Double = (f - 32) / 1.8
            println("$f Fahraneit $c Celcilustur")

        } else if (secim == 2) {
            println("Celcilus değerini girin")
            var c: Double = sc.nextDouble()
            var f: Double = (c * 1.8) + 32
            println("$c Celcilus $f Fahraneittir")


        } else {

            println(" Lütfen 1 veya 2 seçiniz")
        }

    } else if (soru == 3) {
        println("2 adet sayı giriniz")
        var a = sc.nextInt()
        var b = sc.nextInt()
        if (a > b) {
            println("$a büyük sayı . $b küçük sayı")
        } else if (b > a) {
            println("$b büyük sayı . $a küçük sayı")
        } else {
            println("$a ve $b birbirine eşittir")
        }
    } else if (soru == 4) {
        println("Lütfen sayı giriniz")
        var n = sc.nextInt()
        var b = n * (n + 1) / 2
        println("1 den $n e kadar olsan sayıların toplamı = $b ")

    } else if (soru == 5) {
        println("Lütfen bir sayi giriniz")
        var z = sc.nextInt()
        var toplam =0
        while (z>0){
            toplam += z % 10
            z /= 10

        }
        println(toplam)

    } else if (soru == 6) {
        println("Lütfen bir sayi giriniz")
        var a = sc.nextInt()
        while (a > 0) {

            print(a % 10)
            a /= 10
        }
    } else if (soru == 7) {
        println("Kaç tane sayı gireceksiniz ?")
        var a = sc.nextInt()
        var myList = ArrayList<Int>()
        val b = 0
        while (a > 0) {
            println("Bir sayı girin ")

            var b = sc.nextInt()
            myList.add(b)

            a--

        }
        var t = 0
        var c = 0
        var p = 0
        var n = 0
        var z =""

        myList.forEach {
            if (it % 2 == 0) {
                c++
            } else {
                t++
            }


        }
        myList.forEach {
            if (it > 0) {
                p++
            } else if (it == 0){
               println("0 kararsızdır")
            }
            else{
                n++
            }
        }
        val max = myList.max()
        val min = myList.min()
        val ort = myList.average()
        val sum = myList.sum()
        println("Sayılar $myList")
        println("Sayıların en büyüğü $max")
        println("Sayıların en küçüğü $min")
        println("Sayıların ortalaması $ort")
        println("Sayıların toplamı $sum")
        println("Tek sayıların adedi $t")
        println("Çift sayıların adedi $c")
        println("Pozitif sayıların adedi $p")
        println("Negatif sayıların adedi $n")

    } else {
        println("Geçersiz Sayı")
    }


}
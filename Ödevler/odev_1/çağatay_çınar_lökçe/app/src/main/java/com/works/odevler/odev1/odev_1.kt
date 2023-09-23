package com.works.odevler.odev1

import java.util.InputMismatchException
import java.util.Scanner

fun main() {
    ucgenMi()
    dereceDonusum()
    minMax()
    ntotal()
    sayiToplami()
    tersineCevir()
    nsayi()
}

// 1-)
fun ucgenMi (){
    val sc = Scanner(System.`in`)
    try {
        print("1. kenarı giriniz:")
        val kenar1 = sc.nextInt()
        print("2. kenarı giriniz:")
        val kenar2 = sc.nextInt()
        print("3. kenarı giriniz:")
        val kenar3 = sc.nextInt()
        if (kenar1+kenar2>=kenar3 && kenar1+kenar3>=kenar2 && kenar2+kenar3 >= kenar1){
            println("Üçgen Olur.")
        }else{
            println("Üçgen Olmaz.")
        }
    }catch (ex:InputMismatchException){
        println("Parametreleri integer giriniz.")
        ucgenMi()
    }
}

// 2-)
fun dereceDonusum (){
    print("""
        1 - F -> C
	    2 - C -> F
    """)
    val sc = Scanner(System.`in`)

    try {
        print("Seçiminizi giriniz: ")
        val secim = sc.nextInt()
        when (secim) {
            1 -> {
                    print("Fahrenheit değerini giriniz: ")
                    val f = sc.nextFloat()
                    val c = (f - 32) / 1.8
                    println("$f F = $c C")
            }
            2 -> {
                    print("Celcius değerini giriniz: ")
                    val c = sc.nextFloat()
                    val f = 32 + (1.8 * c)
                    println("$f< F = $c C")
            }
            else -> {
                println("Hatalı Seçim")
                dereceDonusum()
            }
        }
    }catch (ex:InputMismatchException){
        println("Lütfen sayısal değer giriniz.")
        dereceDonusum()
    }
}

// 3-)
fun minMax(){
    val sc = Scanner(System.`in`)
    try {
        println("İlk sayıyı giriniz: ")
        val num1 = sc.nextInt()
        println("İkinci sayıyı giriniz: ")
        val num2 = sc.nextInt()

        if ( num1>num2){
            println("Büyük olan $num1, küçük olan $num2")
        }else if ( num2>num1 ){
            println("Büyük olan $num2, küçük olan $num1")
        }else{
            println("Sayılar eşittir.")
        }
    }catch (e:InputMismatchException){
        println("Lütfen bir tamsayı giriniz")
        minMax()
    }
}

// 4-)
fun ntotal(){
    val sc = Scanner(System.`in`)
    try {
        println("Lütfen bir sayı giriniz: ")
        val n = sc.nextInt()
        val total = n*(n+1) / 2
        println("1'den $n'e kadar olan sayıların toplamı $total.")
    }catch (e:InputMismatchException){
        println("Lütfen bir tamsayı giriniz")
        ntotal()
    }
}

// 5-)
fun sayiToplami(){
    try {
        println("Lütfen üç haneli bir sayı giriniz: ")
        val sayi = readln()
        var toplam = 0
        if (sayi.length == 3){
            for ( digit in sayi ){
                toplam += digit.digitToInt()
            }
            println("$sayi sayısının basamakları toplamı $toplam.")
        }else{
            sayiToplami()
        }

    }catch (e:InputMismatchException){
        sayiToplami()
    }
}

// 6-)
fun tersineCevir() {
    try {
        println("Lütfen üç haneli bir sayı giriniz: ")
        val sayi = readln()
        if (sayi.length == 3) {
            val yeniSayi = sayi.reversed()
            println("$sayi sayısının ters çevrilmiş hali $yeniSayi.")
        }else{
            tersineCevir()
        }
    }catch (e:InputMismatchException){
        tersineCevir()
    }
}

// 7-)
fun nsayi(){
    val sc = Scanner(System.`in`)
    var pos = 0
    var neg = 0
    val min:Int
    val max:Int
    var even = 0
    var odd = 0
    var sum = 0
    val avg:Float
    try {
        print("Kaç adet sayı gireceğinizi yazın: ")
        val n = sc.nextInt()
        println()
        val arr = mutableListOf<Int>()
        for ( i in 1..n ){
            print("$i. sayıyı giriniz: ")
            val a = sc.nextInt()
            arr.add(a)
        }
        min = arr.min()
        max = arr.max()
        for( i in arr ){
            if ( i < 0 ){
                neg++
            }
            if ( i > 0 ){
                pos++
            }
            if ( i % 2 == 0 ){
                even++
            }
            else{
                odd++
            }
            sum += i
        }
        avg = (sum/arr.size).toFloat()
        println("""
            
    Girilen ${arr.size} Sayıdan :
    $pos Tanesi Pozitif
    $neg Tanesi Negatif
    En Büyüğü : $max
    En Küçüğü : $min
    $even Tanesi Çift
    $odd Tanesi Tek
    Toplamları : $sum
    Ortalamaları : $avg
        """.trimIndent())
    }catch (e:InputMismatchException){
        println("Lütfen tamsayı bir değer giriniz.")
        nsayi()
    }
}
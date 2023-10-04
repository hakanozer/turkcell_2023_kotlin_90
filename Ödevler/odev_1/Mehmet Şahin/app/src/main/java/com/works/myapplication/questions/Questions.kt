package com.works.myapplication.questions

import java.util.Scanner

fun main(args: Array<String>) {
    //1.Sorunun Cevabı
    //Üçgen kontrolü : Herhangi 2 kenar uzunluğu toplamı diğer kenardan büyükse
    try {
        print("Lütfen ilk kenar uzunluğunu giriniz: ")
        val side1 = readLine()!!.toDouble()
        print("Lütfen ikinci kenar uzunluğunu giriniz: ")
        val side2 = readLine()!!.toDouble()
        print("Lütfen üçüncü kenar uzunluğunu giriniz: ")
        val side3 = readLine()!!.toDouble()
        //Pozitif sayı kontrolu
        if(side1 <= 0 || side2 <= 0 || side3 <= 0) {
            println("Lütfen pozitif bir sayı giriniz!!")
        } else {
            val sm12= side1 + side2
            val sm13 = side1 + side3
            val sm23 = side2 + side3

            if(sm12> side3 && sm13 > side2 && sm23 > side1 ) {
                println("Girdiğiniz sayılarla üçgen oluşturabilirsiniz")
            } else {
                println("Girdiğiniz sayılarla üçgen oluşturamazsınız!")
            }
        }

    } catch(ex: Exception) {
        println("Hatalı giriş! Lütfen geçerli bir sayı giriniz!!")
    }

  //2.Sorunun Cevabı
    println("Menu :")
    println("1 - F -> C")
    println("2 - C -> F")
    println("Secim :")
    val scanner1 = Scanner(System.`in`)
    val select = scanner1.nextInt()
    when(select) {
        1 -> {
            println("Lütfen fahren değeri giriniz:")
            var selectF = scanner1.nextDouble()
            val calF = (selectF-32)/1.8
            println("x $selectF = y $calF")

        }
        2 -> {
            println("Lütfen celcius değeri giriniz:")
            var selectC = scanner1.nextDouble()
            val calC = (selectC*1.8) +32
            println("x $selectC = y $calC")
        }
        else-> {
            println("Hatalı seçim!! Lütfen 1 veya 2 seçiniz!")
        }
    }


//3.Soru
    try{
        val scanner = Scanner(System.`in`)
        print("Lütfen ilk sayıyı giriniz : ")
        val scannerF = scanner.nextInt()
        print("Lütfen ikinci sayıyı giriniz : ")
        val scannerS = scanner.nextInt()
        if(scannerF > scannerS) {
            println("Büyük sayı: $scannerF, Küçük sayı: $scannerS")
        }else if(scannerS > scannerF) {
            println("Büyük sayı: $scannerS, Küçük sayı: $scannerF")

        }else {
            println("İki sayı birbirine eşittir")

        }

    }catch(ex: Exception){
        println("Hatalı giriş!")
    }

     //4.Soru
    //n'e kadar olan sayıların toplamı
    try {
        val scanner = Scanner(System.`in`)
        print("Lütfen bir sayı giriniz: ")
        var num = scanner.nextInt()
        var calNum = (num*(num+1))/2
        println("1'den $num'a kadar olan Sayıların toplamı : $calNum")
    }catch (ex: Exception) {
        println("Hatalı giriş! Lütfen bir sayı giriniz")
    }


    //5.Soru
    //Basamakların toplamını yazdırma
    try {
        print("Lütfen basamaklarının toplanmasını istediğiniz sayı giriniz: ")
        val scanner = Scanner(System.`in`)
        var divide = scanner.nextLine()
        var arr = IntArray(divide.length)
        for(i in 0.. divide.length-1) {
            arr[i] = divide[i].toString().toInt()
        }
        var sum= 0
        for(j in arr) {
            sum +=j
        }
        println(sum)
    } catch(ex: Exception) {
        println("Hatalı giriş lütfen tam sayı giriniz!!")
    }


    //6.Soru
    //Sayıların tersini alan
    try {
        println("Lütfen sayı giriniz: ")
        val scanner = Scanner(System.`in`)
        var divide = scanner.nextLine()
        var arr = IntArray(divide.length)
        for(i in 0.. divide.length-1) {
            arr[i] = divide[i].toString().toInt()
        }
        arr.reverse()
        for(item in arr) {
            print(item)
        }
        println()
    } catch(ex: Exception) {
        println("Hatalı giriş lütfen tam sayı giriniz!!")
    }

    //7.Soru
    val scanner = Scanner(System.`in`)
    println("Kaç adet sayı gireceksiniz? : ")
    val scannerN = scanner.nextInt()
    val arr = mutableListOf<Int>()
    for(i in 1..scannerN){
        println("$i . Sayınızı giriniz")
        var number = scanner.nextInt()
        arr.add(number)
    }

    println(arr)

    var positiveNum = 0
    var negativeNum =0
    var evenNum = 0
    var oddNum = 0
    var sum = 0

    for(item in arr) {
        sum += item
        if (item>0) {
            positiveNum++
        }else if(item < 0) {
            negativeNum++
        }

        if(item%2 == 0 ) {
            evenNum++
        }else{
            oddNum++
        }

    }

    val avr = sum.toDouble()/scannerN.toDouble()
    val maxNum = arr.max()
    val minNum = arr.min()

    println("Girilen $scannerN Sayıdan")
    println("$positiveNum tanesi pozitif")
    println("$negativeNum tanesi negatif")
    println("En büyüğü: $maxNum")
    println("En küçüğü: $minNum")
    println("$evenNum tanesi çift")
    println("$oddNum tanesi tek")
    println("Toplamı : $sum")
    println("Ortalaması : $avr")


}
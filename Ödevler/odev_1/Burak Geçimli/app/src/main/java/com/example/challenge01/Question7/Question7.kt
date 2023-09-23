package com.example.challenge01.Question7

import com.example.challenge01.Question4.sumNumber
import java.lang.Exception
import kotlin.math.sign

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
    val numberList = ArrayList<Int>()
    try {
        println("Dizi kaç elemanlı olacak")
        val size = readln().toInt()

        if (size > 0) {
            println("Lütfen $size adet sayı girin:")
            for (i in 1..size) {
                val num = readln().toInt()
                numberList.add(num)
            }
            report(numberList)
        } else {
            println("Dizi boyutu 0 veya aşağısı olamaz!")
        }

    } catch (e: Exception) {
        println("Dizi boyutu ve elemanları bir tam sayı olmalı!")
    }
}


fun findSum(numberList: ArrayList<Int>): Int {
    var sum = 0
    numberList.forEach {
        sum += it
    }
    return sum
}

fun findAverage(numberList: ArrayList<Int>): Int {
    val sum = findSum(numberList)
    val average = sum / numberList.size
    return average

}

fun counterPositiveNegative(numberList: ArrayList<Int>): Pair<Int, Int> {
    var positiveCounter = 0
    var negativeCounter = 0

    numberList.forEach { number ->
        if (number > 0) {
            positiveCounter++
        } else if (number < 0) {
            negativeCounter++
        }
    }

    return Pair(positiveCounter, negativeCounter)

}

fun findMaxMin(numberList: ArrayList<Int>): Pair<Int, Int> {
    var min = numberList.first()
    var max = numberList.first()

    numberList.forEach { number ->
        if (number < min) {
            min = number
        }
        if (number > max) {
            max = number
        }

    }

    return Pair(max, min)
}

fun counterEvenOdd(numberList: ArrayList<Int>): Pair<Int, Int> {
    var evenCounter = 0
    var oddCounter = 0
    numberList.forEach { number ->
        if (number % 2 == 0) {
            evenCounter++

        } else {
            oddCounter++
        }
    }
    return Pair(evenCounter, oddCounter)

}


fun report(numberList: ArrayList<Int>) {
    val (positiveCounter, negativeCounter) = counterPositiveNegative(numberList)
    val (evenCounter, oddCounter) = counterEvenOdd(numberList)
    val (max, min) = findMaxMin(numberList)
    val sum = findSum(numberList)
    val average = findAverage(numberList)


    println("$positiveCounter tanesi pozitif")
    println("$negativeCounter tanesi negatif")
    println("$evenCounter tanesi çift")
    println("$oddCounter tanesi tek")
    println("En büyük sayı= $max")
    println("En küçük sayı=$min")
    println("Toplamları=$sum")
    println("Ortalamaları=$average")


}






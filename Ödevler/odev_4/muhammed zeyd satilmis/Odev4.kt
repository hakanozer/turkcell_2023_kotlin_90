package com.example.kotlin_day1._odevler_

import java.math.BigInteger
import kotlin.random.Random

fun main(args: Array<String>) {
    // Soru 1:
    randomNums();
    // Soru 2:
    totalString()
    // Soru 4:
    forList()
    // Soru 5:
    setList()
    // Soru 6:
    val list = listOf(1, 2, 3, 2, 1, 1, 1, 5)
    repeatList(list, 1)
    // Soru 7:
    age()
    // Soru 8:
    val listSum = listOf(-1, 3, -2, 5)
    val sum = sumPositives(listSum)
    println("Pozitif sayıların toplamı: $sum")
    // Soru 9:
    val filterList = listOf<Any?>(1, 5, 4, 21, 65, null, 44, null, null)
    val filter = filterNonNull(filterList)
    println(filter)
    // Soru 10:
    textLength()
    // Soru 11:
    descent()
    // Soru 12:
    setCompare()
}


// Soru 1:
fun randomNums() {
    val minSayi = 1
    val maxSayi = 49
    val sayiAdedi = 6

    if (maxSayi - minSayi + 1 < sayiAdedi) {
        println("Hata: Belirtilen aralıkta yeterli farklı sayı yok.")
    } else {
        val secilenSayilar = mutableSetOf<Int>()

        while (secilenSayilar.size < sayiAdedi) {
            val rastgeleSayi = Random.nextInt(minSayi, maxSayi + 1)
            secilenSayilar.add(rastgeleSayi)
        }

        println("Seçilen 6 farklı sayı: ${secilenSayilar.joinToString(", ")}")
    }
}


// Soru 2:
fun totalString() {
    val a = "23456789876543234567890987654567890"
    val b = "99999999999988888888882222222688981"

    val bigIntA = BigInteger(a)
    val bigIntB = BigInteger(b)

    val toplam = bigIntA.add(bigIntB)

    println("Toplam: $toplam")
}

// Soru 3:
// Soru 4:
fun forList() {
    val list = listOf("A", "B", "C", "D", "E", "F")
    list.forEach { item ->
        println(item)
    }
}

// Soru 5:
fun setList() {
    val set = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val combined = set.intersect(list).toList()

    println(combined)
}

// Soru 6:
fun repeatList(list: List<Int>, value: Int): Int {
    var count = 0
    for (item in list) {

        if (item == value) {
            count++
        }
    }
    println(count)
    return count
}

// Soru 7:
fun age() {
    val ages = listOf(18, 20, 22, 25, 30, 35, 40, 45, 50, 55)


    val ageGroups = ages.groupBy { it / 10 }


    println(ageGroups)
}

// Soru 8:
fun sumPositives(list: List<Int>): Int {

    var sum = 0
    for (item in list) {

        if (item > 0) {
            sum += item
        }
    }
    return sum
}

// Soru 9:
fun filterNonNull(list: List<Any?>): List<Any> {

    val result = mutableListOf<Any>()
    for (item in list) {

        if (item != null) {
            result.add(item)
        }
    }
    return result
}

// Soru 10:
fun textLength() {

    val list = listOf("An,Fen", "Etc", "Fenerbahçe", "Dünya", "K")

    val sortedList = list.sortedBy { it.length }

    val shortest = sortedList.first()
    val longest = sortedList.last()

    println("En kısa metin: $shortest")
    println("En uzun metin: $longest")

}

// Soru 11:
fun descent() {
    val list = mutableListOf(12, 3, 6, 9, 1, 5, 7, 8, 4)
    list.sortDescending()
    println(list)
}

// Soru 12:
fun setCompare(): Unit {
    val set1 = setOf(1, 2, 3, 4, 5)
    val set2 = setOf(2, 3, 4, 6, 7)

    val common = set1.intersect(set2)

    println(common)

}
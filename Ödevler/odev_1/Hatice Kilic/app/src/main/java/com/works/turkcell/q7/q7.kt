package com.works.turkcell.q7


import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Kac sayi gireceksiniz ? ")
    val number = scanner.nextInt()

    val numbers = arrayListOf<Double>()
    var positifNumber: Int = 0
    var negatifNumber = 0

    for (i in 1..number){
        println("$i.sayiyi giriniz")
        val number = scanner.nextDouble()
        numbers.add(number)
        if ( number >= 0){
            positifNumber++
        }else if (number < 0){
            negatifNumber++
        }
    }
    println("Girilen $number sayidan: ")
    println("$positifNumber tanesi pozitif")
    println("$negatifNumber tanesi negatif")


    val higher = findHigherNumber(numbers)
    if (higher != null){
        println("En buyugu : $higher")
    }else{
        println("En buyuk sayi bulunamadi")
    }

    val lower = findLowerNumber(numbers)
    if (lower != null){
        println("En kucugu : $lower")
    }else{
        println("En kucuk sayi bulunamadi")
    }

    val evenNumber= countEvenNumber(numbers)
    println("$evenNumber Tanesi cift")

    val oddNumber= countOddNumber(numbers)
    println("$oddNumber Tanesi tek")

    val sum = findSumNumber(numbers)
    println("Toplamlari :  $sum")

    val avarage = findAvarage(numbers)
    println("Ortalamalari : $avarage")

}

fun findHigherNumber(numbers: List<Double>): Double? {

    var higherNumber = numbers [0]
    for (number in numbers){
        if (number > higherNumber)
            higherNumber = number
    }
    return higherNumber
}

fun findLowerNumber(numbers: List<Double>): Double? {

    var lowerNumber = numbers [0]
    for (number in numbers){
        if (number < lowerNumber)
            lowerNumber = number
    }
    return lowerNumber
}


fun countEvenNumber (numbers: List<Double>): Int {

    return numbers.count {it % 2 == 0.0 && it > 0}
}

fun countOddNumber (numbers: List<Double>): Int {

    return numbers.count {it % 2 != 0.0 && it > 0}
}

fun findSumNumber(numbers: List<Double>): Double {
    var sum = 0.0
    for (number in numbers){
        sum += number
    }
    return sum
}

fun findAvarage (numbers: List<Double>): Double {
    var total = 0.0
    for (number in numbers) {
        total += number
    }
    return total / numbers.size
}








package com.bugcompany.challenge02.`Question1-10`

import kotlin.math.abs
import kotlin.math.pow


fun main(args: Array<String>) {
    println(isPrime(59))
    println(sumNumbers(5, 8))
    println(calculator(1, 6))
    println(findSumOfDigit(123456789))
    println(reverseNumber(123456))
    println(calculatorBMI(75.9, 1.87))
    println(isPalindrome(11011))
    println(findMinMaxValueOfArray(arrayOf(8, 5, 3, 9, 7)))
    println(findValueInArray(arrayOf(10, 20, 30, 40), 10))
    println(findMax())

}

//Question 1
fun isPrime(num: Int): Boolean {
    if (num < 2) {
        return false
    }

    if (num == 2) {
        return true
    }

    for (i in 2..num / 2) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}


//Question 2
fun sumNumbers(num1: Int, num2: Int): Int {
    var sum = 0
    for (number in (num1 + 1)..num2) {
        sum += number
    }
    return sum
}

//Question 3
fun calculator(num1: Int, num2: Int): Double {

    val result = if (num1 % 2 == 1) {
        num1.toDouble() / num2
    } else {
        num1.toDouble() % num2
    }
    return result
}

//Question 4
fun findSumOfDigit(number: Long): Int {
    var sum = 0
    var mutlak = abs(number)
    while (mutlak > 0) {
        val rakam = mutlak % 10
        sum += rakam.toInt()
        mutlak /= 10
    }
    return sum
}

//Question 5
fun calculatorBMI(weight: Double, height: Double): Double {
    return weight / height.pow(2)
}

//Question 6
fun reverseNumber(number: Int): Int {
    val numberStr = number.toString()
    return numberStr.reversed().toInt()
}

//Question 7
fun isPalindrome(number: Int): Boolean {
    val reverseNumber = number.toString().reversed()
    val result = number.toString() == reverseNumber
    return result
}

//Question 8
fun findMinMaxValueOfArray(numberArray: Array<Int>): Int {
    if (numberArray.isEmpty()) {
        println("Array is empty")
    }

    var maxValue = numberArray.first()
    var minValue = numberArray.first()

    for (number in numberArray) {
        if (number > maxValue) {
            maxValue = number
        } else if (number < minValue) {
            minValue = number
        }
    }
    return minValue + maxValue
}


//Question 9
fun findValueInArray(numberArray: Array<Int>, number: Int): Boolean {
    var result = false
    for (value in numberArray) {
        if (value == number) {
            result = true
            break
        }
    }
    return result
}

//Question 10
fun findMax(): Int? {
    val numbers = mutableListOf<Int>()

    for (i in 1..4) {
        try {
            println("Enter the $i. number: ")
            val input = readlnOrNull()
            val number = input?.toInt() ?: throw NumberFormatException()
            numbers.add(number)
        } catch (e: NumberFormatException) {
            println("Invalid integer entered. Please try again.")
        }
    }

    return numbers.maxOrNull()
}







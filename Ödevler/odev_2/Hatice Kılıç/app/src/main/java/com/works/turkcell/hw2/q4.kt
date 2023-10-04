package com.works.turkcell.hw2

fun main(args: Array<String>) {
    val long = total(9875)
    println("$long")
}

fun total(number: Int): Int {
    var sum = 0
    var remainingNumber = number

    while (remainingNumber > 0){
        val num =remainingNumber % 10
        sum += num
        remainingNumber /= 10

    }
    return sum
}
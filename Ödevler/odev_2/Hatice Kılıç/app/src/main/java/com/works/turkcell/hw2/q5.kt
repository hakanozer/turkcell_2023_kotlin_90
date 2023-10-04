package com.works.turkcell.hw2

fun main(args: Array<String>) {

    val bmi = bodyMassIndex(78.0,189.0)
    println("$bmi")
}

fun bodyMassIndex(weight:Double, height:Double) :Double {
    var bmi = 0.0
    bmi = weight / (height * height)
    return bmi

}
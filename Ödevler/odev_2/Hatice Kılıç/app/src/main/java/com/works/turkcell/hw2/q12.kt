package com.works.turkcell.hw2

fun main(args: Array<String>) {
    val number1 = 6.0
    val number2 = 0.0
    try {
        val sonuc = division(number1,number2)
        println("$sonuc")
    }catch (ex:ArithmeticException){
        println("Sayi bolu sifir tanimsizdir")
    }
}

fun division (number1:Double, number2: Double) :Double {
    if (number2 == 0.0){
        throw ArithmeticException("Bolme hatasi")
    }
    return number1 / number2
}
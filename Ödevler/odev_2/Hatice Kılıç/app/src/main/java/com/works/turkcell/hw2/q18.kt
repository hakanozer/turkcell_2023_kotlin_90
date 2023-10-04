package com.works.turkcell.hw2

fun main(args: Array<String>) {

    println("Lutfen bir sayi giriniz.")
    val number1 = readLine()

    println("Lutfen ikinci bir sayi giriniz.")
    val number2 = readLine()

    if (number1 != null && number2 != null) {
        try {
            val num1 = number1.toDouble()
            val num2 = number2.toDouble()
            if (num1 >= 0 && num2 >= 0) {
                var result = num1 * num2
                println("sonuc: $result")
            } else
                println("Lutfen integer degerler giriniz")

        } catch (ex: NumberFormatException) {
            println(ex.message)
        }
    }
}
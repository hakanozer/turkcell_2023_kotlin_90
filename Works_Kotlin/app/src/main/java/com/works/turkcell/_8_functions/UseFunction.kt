package com.works.turkcell._8_functions

import com.works.turkcell._7_loop.profileName
import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Num -1")
    val n1 = scanner.nextInt()
    println("Num -2")
    val n2 = scanner.nextInt()

    val sm = sum(n1,n2)
    println("Sum : $sm")

    minus(n1, n2)
    minus(56,12)
    minus(34,16)

    val name = read()
    println("Adınız: $name")

    println(status)
    println(profileName)

    fncRec(0)
}

// Fonksiyonlar
// fun anahtar kelimesi ile başlar
// isimlendirme alırlar fun sum() "sum" burada fonksiyon ismidir.
// parametre alırlar fun sum(num1: Int, num2: Int)
// return (Geri dönüş değeri alırlar)

fun sum( num1: Int, num2: Int ) : Int {
    // body
    val total = num1 + num2
    return total
}

fun minus(num1: Int, num2: Int) {
    val min = num1 - num2
    println("Minus: $min")
}

fun read() : String {
    val scanner = Scanner(System.`in`)
    println("Adınız!")
    val name = scanner.nextLine()
    return name
}

var number = 10
fun fncRec(num: Int) {
    number--
    if (number >= 0) {
        println("Call - $number")
        fncRec(num)
    }
}


package com.works.turkcell.q2
import java.util.Scanner


fun main(args: Array<String>) {

    val menu = ("Menu: \n1 - F -> C \n2 - C -> F\t\n  Secim:")
    println(menu)
    var choose = readLine()

    when (choose) {
        "1" -> {
            val scanner = Scanner(System.`in`)
            println("Lutfen bir Fahrenheit degeri giriniz = fah ")
            val f = scanner.nextFloat()
            val c = (f - 32) * 5 / 9
            println("$f F = $c C")
        }

        "2" -> {
            val scanner = Scanner(System.`in`)
            println("Lutfen bir Celcius degeri giriniz = cel ")
            val c = scanner.nextFloat()
            val f = (c * 9 / 5) + 32
            println("$c C = $f F")
        }

        else -> {
            println("Hatali secim yaptiniz")
        }

    }
}










package com.works.turkcell.hw2

import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("0 ile 20 arasindan 5 sayi seciniz. ")

    val numbers = mutableListOf<Int>()

    try {
        for (i in 1..5) {
            println("Sectiginiz $i.sayiyi giriniz")
            val number = scanner.nextDouble()
            if (number > 0 && number < 20) {
                numbers.add(number.toInt())
            }
        }
    } catch (ex: Exception) {
        println("Lutfen gecerli bir sayi giriniz")
    }

    val evenNum = mutableListOf<Int>()
    val oddNum = mutableListOf<Int>()

    for (sayi in numbers){
        if (sayi % 2 == 0 ) {
            evenNum.add(sayi)
        }else{
            oddNum.add(sayi)
        }
    }

    println("Even Numbbers: $evenNum")
    println("Odd Numbers: $oddNum")
    val evenavarage = evenNum.average()
    val oddavarage = oddNum.average()
    println("Even Avarage : $evenavarage")
    println("Odd Avarage : $oddavarage")
}


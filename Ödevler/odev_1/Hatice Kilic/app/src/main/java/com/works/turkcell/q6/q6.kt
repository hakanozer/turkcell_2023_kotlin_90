package com.works.turkcell.q6

import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Lutfen bir uc basamakli bir sayi giriniz ")
    val number = scanner.nextInt()

    if ( number in 100..999){
        val birler = number % 10
        val onlar = (number / 10) % 10
        val yuzler = number / 100
        val backnumber = birler * 100 + onlar * 10 + yuzler
        println("Girilen sayinin rakamlarinin tersten yazimi $backnumber")
    }else{
        println("Lutfen uc basamakli bir sayi giriniz ")
    }


}
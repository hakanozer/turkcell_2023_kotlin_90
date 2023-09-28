package com.works.turkcell.q3

fun main(args: Array<String>) {

    println("Lutfen bir sayi giriniz.")
    val number1 = readLine()

    println("Lutfen ikinci bir sayi giriniz.")
    val number2 = readLine()

    if (number1 != null && number2 != null){
        try {
            val n1 = number1.toInt()
            val n2 = number2.toInt()
            if ( n1 > n2 ){
                println("n1: $n1")
            }else if ( n2 > n1 ){
                println("n2: $n2")
            }else{
                println("Girdiginiz degerler esittir.")
            }
        }catch (ex: Exception){
            println("Lutfen pozitif bir tam sayi giriniz")
        }


    }





}


package com.work_turkcell._odev

fun main(args: Array<String>) {
    println("Lütfen 2 sayı giriniz")
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    if(a > b){
        println("$a büyük, $b küçük")
    }
    else if (a == b){
        println("Bu sayılar eşittir")
    }
    else{
        println("$b büyük, $a küçük")
    }
}
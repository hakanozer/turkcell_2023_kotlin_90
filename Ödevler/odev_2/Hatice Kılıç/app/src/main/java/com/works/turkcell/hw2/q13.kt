package com.works.turkcell.hw2

import kotlin.NumberFormatException

fun main(args: Array<String>) {
    println("Lutfen bir sayi giriniz")
    val sayi = readLine()
    try {
        val number = sayi?.toInt() ?: throw NumberFormatException("Lutfen gecerli bir sayi giriniz")
        println("Girilen deger sayidir")
    }catch (ex:NumberFormatException){
        println("Girilen deger sayi degildir")
    }



}

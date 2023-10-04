package com.example.alimertkireciodev2

import java.util.Scanner

fun main(args: Array<String>) {
    try {
        var scanner=Scanner(System.`in`)
        println("Lütfen Birinci Stringi giriniz!")
        var ifadebir= readLine().toString()
        println("Lütfen 2 İfadeyi giriniz")
        var ifadeiki=readLine().toString()

        if (ifadebir.length != ifadeiki.length) {
            println("Hata: İki string ifadenin karakter sayıları eşit değil!")
        } else {
            println("İki string ifadenin karakter sayıları eşit.")
        }
    }catch (ex:Exception){
        println("Hatalı Girdi")
    }

    }

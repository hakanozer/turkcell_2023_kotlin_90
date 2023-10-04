package com.example.alimertkireciodev2

import java.util.Scanner

fun main(args: Array<String>) {
    try {
        var scanner=Scanner(System.`in`)
        println("Lütfen 1. Değeri Giriniz!")

        var birinci=scanner.nextInt()

        println("Lütfen 2. Değeri Giriniz!")
        var ikinci=scanner.nextInt()
        var islem=(birinci+ikinci)/2
        println(islem)
    }catch (ex:Exception){
        println("Lütfen İnteger Degerler giriniz!!")
    }

}
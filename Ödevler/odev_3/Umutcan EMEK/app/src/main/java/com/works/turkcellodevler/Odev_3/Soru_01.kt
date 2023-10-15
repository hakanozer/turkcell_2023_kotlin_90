package com.works.turkcellodevler.Odev_3

import java.io.File
import java.util.Scanner

/*
#1.
Notepad++ İle Bir Dosya Oluşturun
İçine 15 Tane Sayı Yazın (Arada Pozitif, Negatif Sayılarda Olsun)

Uygulamanıza Bu Dosyanın Yolunu Vereceksiniz.Uygulamanız Ekrana
Dosyada Kaç Tane :
- Pozitif
- Negatif
- Tek
- Çift Sayı Olduğunu Bastıracak.
 */

fun main(args: Array<String>) {

    val file = File("C:\\Users\\umutc\\Desktop\\num.txt")
    val lines = file.readLines()
    var positiveNums = 0
    var negativeNums = 0
    var oddNums = 0
    var evenNums = 0

    for (line in lines){
        val num = line.trim().toInt()
        if (num > 0){
            positiveNums++
        }else if (num < 0){
            negativeNums++
        }
        if (num % 2 == 1){
            oddNums++
        }else{
            evenNums++
        }
    }
    println("Dosya içerisinde bulunan pozitif sayı adeti: $positiveNums")
    println("Dosya içerisinde bulunan negatif sayı adeti: $negativeNums")
    println("Dosya içerisinde bulunan tek sayı adeti: $oddNums")
    println("Dosya içerisinde bulunan çift sayı adeti: $evenNums")

}

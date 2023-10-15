package com.works.turkcellodevler.Odev_3

import java.io.File

/*
#3. 2. Soruda Oluşturduğunuz Dosyayı Açıp Okuyan, Input Dosyasının Bulunduğu Klasore
C.txt Adında Bir Dosya Oluşturup, Input Dosyasının İçindeki Cift Sayıları Yazan,
T.txt Adında Bir Dosya Olusturup, Tek Sayıları Yazan Bir Uygulama Yazın
 */

fun main(args: Array<String>) {

    val inputFile = File("C:\\Users\\umutc\\Desktop\\num.txt")
    val evenFile = File("C:\\Users\\umutc\\Desktop\\even.txt")
    val oddFile = File("C:\\Users\\umutc\\Desktop\\odd.txt")

    val scope = inputFile.readLines().map { it.toInt() }
    val evenNums = mutableListOf<Int>()
    val oddNums = mutableListOf<Int>()

    for (num in scope) {
        if (num % 2 == 0) {
            evenNums.add(num)
        } else {
            oddNums.add(num)
        }
    }
    for (evenNum in evenNums) {
        evenFile.appendText("$evenNum\n")
    }
    for (oddNum in oddNums) {
        oddFile.appendText("$oddNum\n")
    }
    println("Tek sayılar odd.txt dosyasına yazıldı.")
    println("Çift sayılar even.txt dosyasına yazıldı.")

}


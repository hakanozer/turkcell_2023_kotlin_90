package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
10 - kullanıcıdan 4 tane int değer alan,
ve en büyük olan değeri geri döndüren bir
method yazın
 */

fun main(args: Array<String>) {

    maxNum()

}

fun maxNum(){
    var num: Int
    var bigNum = 0
    for (i in 1..4){
        print("$i. sayıyı giriniz: ")
        var scanner = Scanner(System.`in`)
        num = scanner.nextInt()
        if (num > bigNum || bigNum == 0){
            bigNum = num
        }
    }
    println(bigNum)

}
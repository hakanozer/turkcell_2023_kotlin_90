package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
25- Kullanıcıdan pozitif bir tam sayı alınız ve
bu sayının faktöriyelini hesaplayınız. Kullanıcı metin veya
negatif bir tam sayı girişi yaptığında try-catch ile hata mesajları görüntüleyiniz. (Mehmet Şahin)
 */

fun main(args: Array<String>) {

    try {
        print("Faktöriyelini hesaplamak istediğiniz sayıyı giriniz: ")
        var result = 1
        val scanner = Scanner(System.`in`)
        val num = scanner.nextInt()
        for (i in 1..num){
            result *= i
        }
        println("$num! = $result")
    }catch (ex: Exception){
        println("Lütfen ilgili alana pozitif tam sayılar haricinde veri girmeyiniz.")
    }


}
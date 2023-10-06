package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
27- Sizden buraya kaçıncı soruyu yazdığınızı örnek olarak girmeniz isteniyor.
Geçersiz bir sayı veya karakter girildiğinde hata mesajı bastırınız
ve kaçıncı soruyu yazdığınızın yeniden girilmesini sağlayınız.
(soru sayısını 50 olarak alabilirsiniz.) (Berin Aslantaş)
 */

fun main(args: Array<String>) {

    try {
        var status = true
        print("Soru sayfasınadaki kaçıncı soru sizin: ")
        val scanner = Scanner(System.`in`)
        val answer = scanner.nextInt()
        if (answer < 1 || answer > 50){
            println("Hatalı değer girdiniz!")
                status = false

        }else{
            println("$answer. soruyu siz yazdınız.")
            status = true
        }

        while (status == false){
            println("Soru sayfasınadaki kaçıncı soru sizin?")
            val scanner = Scanner(System.`in`)
            val answer = scanner.nextInt()
            if (answer >= 1 && answer <= 50){
                println("$answer. soruyu siz yazdınız.")
                status = true
            }
        }

    }catch (ex: Exception){
        println("İlgili alana sadece sayısal değer giriniz.")
}


}

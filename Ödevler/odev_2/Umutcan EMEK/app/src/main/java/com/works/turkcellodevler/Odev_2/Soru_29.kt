package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
29-Bir Quiz uygulaması geliştirin bir soru sorun doğru cevap verince tebrik mesajı , yanlış cevap verince hata mesajı versin.
( Oğuz Baran Şahingil)
 */

fun main(args: Array<String>) {

    // Bu sorunun try-catch gerektirdiğini düşünmüyorum.

    val qustion = "Bigisayardaki geçiçi hafızaya verilen ad nedir: "
    val answer = "Ram"

    print(qustion)
    val scanner = Scanner(System.`in`)
    val userAnswer = scanner.nextLine()

    if (userAnswer.equals(answer, true)){
        println("Tebrikler doğru cevap!")
    }else{
        println("Maalesef cevabınız yalnış.")
    }

}
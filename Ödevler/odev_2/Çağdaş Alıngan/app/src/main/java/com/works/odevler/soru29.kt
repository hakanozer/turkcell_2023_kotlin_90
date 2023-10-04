package com.works.odevler

import java.util.Scanner

/**
 *29-Bir Quiz uygulaması geliştirin bir soru sorun doğru cevap verince tebrik mesajı
 *  yanlış cevap verince hata mesajı versin. ( Oğuz Baran Şahingil)
 */
fun main(args: Array<String>) {
   val scanner = Scanner(System.`in`)

    try {
        println("""“Günlük hayatta karşılaştığımız, çözüm aranması gereken ve çözümü için bilgi, mantık, deneyim yada dikkat isteyen durumlardır.”
Tanımı verilen kavram aşağıdakilerden hangisidir?
A) Algoritma B) Program C) Problem D) Bilgi
        """.trimMargin())
        val cevap= scanner.nextLine()

        if (cevap.equals("C") || cevap.equals("c")){
            println("Doğru cevap")
        }else{
            println("Yanlış cevap")
        }
    }catch (ex:Exception){
        println("Lütfen Metin değeri giriniz")
    }
}
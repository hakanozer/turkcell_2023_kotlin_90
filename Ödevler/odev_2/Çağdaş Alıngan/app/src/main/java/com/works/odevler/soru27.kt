package com.works.odevler

import java.lang.RuntimeException
import java.util.Scanner

/**
 *27- Sizden buraya kaçıncı soruyu yazdığınızı örnek olarak girmeniz isteniyor.
 * Geçersiz bir sayı veya karakter girildiğinde hata mesajı bastırınız
 * ve kaçıncı soruyu yazdığınızın yeniden girilmesini sağlayınız.
 * (soru sayısını 50 olarak alabilirsiniz.) (Berin Aslantaş)
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    try {
        println("Kaçıncı soruyu yazıyorsunuz")
        val soruSayisi = scanner.nextInt()
        if (soruSayisi <= 30){
            println(soruSayisi)
        }else if (soruSayisi >= 30){
            throw  RuntimeException("Soru sayısı maximum sınır aşımı !!! Toplam 30 soru var.")
        }


    }catch (ex:Exception){
        println(ex.message)
    }
}
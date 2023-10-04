package com.works.odevler

import java.util.Scanner

/**
 *13 - kullanıcıdan bir sayi alan ve bu sayıyı ekrana gösteren bir değer alın girilen değerin sayı olup olmadığını
 * try-cath ile kontrol edip hata yönetimini sağlayın. (Görkem Arslanboğan)
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Sayı giriniz!")
    try {
        val n: Int = scanner.nextInt()
        println(n)
    }catch (ex:Exception){
        println("Hata yakalandı ${ex.message}")
    }
}
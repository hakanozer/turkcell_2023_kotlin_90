package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
13 - kullanıcıdan bir sayi alan ve bu sayıyı ekrana gösteren bir değer alın girilen değerin sayı olup olmadığını
try-cath ile kontrol edip hata yönetimini sağlayın. (Görkem Arslanboğan)
 */

fun main(args: Array<String>) {

    print("Bir sayı giriniz: ")
    try {
        var scanner = Scanner(System.`in`)
        var num = scanner.nextInt()
        println("Girdiğiniz Sayı: $num")
    }catch (ex:Exception){
        println("Lütfen ilgili bölüme sayı girdiğinizden emin olun.")
    }

}
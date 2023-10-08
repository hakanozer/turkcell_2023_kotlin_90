package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
28- Kullanıcıdan ‘ Lys  ’ puanını girmesini isteyin. Girilen puan aralığını kontrol edin.
Puanı 400-430 arasında ise ‘ Mühendislik Fakültesi’ne yerleşebilirsiniz ’ , değilse ‘ Üzülme, Vazgeçme ! 😊
’mesajını ekrana basın. Ve Finally ile ‘ İşlem Tamamlandı ’ mesajını yazdırın.
( Kullanıcıdan alınan değerin 0, null ve String olma durumlarını kontrol edin )  ( ESMA SALKIM )
 */

fun main(args: Array<String>) {

    try {
        print("LYS puanınızı giriniz: ")//560 max puan
        val scanner = Scanner(System.`in`)
        val point = scanner.nextInt()

        if (point < 0 || point > 560){
            println("Puanınızı doğru girdiğinizden emin olun.")
            return
        }
        if (point >= 400){
            println("Mühendislik Fakültesi’ne yerleşebilirsiniz!")
        }else{
            println("Üzülme, Vazgeçme ! \uD83D\uDE0A")
        }
    }catch (ex: Exception){
        println("Girdiğiniz değerin bir sayı olduğundan emin olunuz.")
    }


}
package com.works.odevler

import androidx.core.util.rangeTo
import java.lang.RuntimeException
import java.util.Scanner

/**
 * 28- Kullanıcıdan ‘ Lys  ’ puanını girmesini isteyin. Girilen puan aralığını kontrol edin.
 * Puanı 400-430 arasında ise ‘ Mühendislik Fakültesi’ne yerleşebilirsiniz ’ , değilse ‘ Üzülme, Vazgeçme ! 😊
 * ’mesajını ekrana basın. Ve Finally ile ‘ İşlem Tamamlandı ’ mesajını yazdırın.
 * ( Kullanıcıdan alınan değerin 0, null ve String olma durumlarını kontrol edin )  ( ESMA SALKIM )
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    try {


        println("Lütfen Lys puanınızı giriniz")
        val puan = scanner.nextInt()
        if (puan in 400..430) {
            println("Mühendislik Fakültesi’ne yerleşebilirsiniz !!")
        } else if (puan < 400) {
            println("Mühendislik fakültesi için yetersiz puan aralığındasınız !!")
        } else if (puan > 430) {
            throw RuntimeException("Hata!! 430'dan yüksek değer giremezsiniz !!")
        }
    }catch (ex:Exception){
        println(ex.message)

    }finally {
        println("İşlem tamamlandı")
    }
}
package com.tutkuzdmr.odev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Scanner

/* Kullanıcıdan 2 Sayı Alıyorsunuz
Bu 2 Büyük ve Küçük Olanını Ekrana Bastırıyorsunuz
Eğer Sayılar Eşitse Sayılar Eşittir Mesajını
Ekrana Bastırıyorsunuz */

fun main(args: Array <String>){

    val scanner = Scanner(System.`in`)

    println("1.sayiyi giriniz:")
    val sayi1 = scanner.nextInt()

    println("2.sayiyi giriniz:")
    val sayi2 = scanner.nextInt()

    if (sayi1 > sayi2) {
        println("Buyuk sayi: $sayi1")
        println("Kucuk sayi: $sayi2")
    } else if (sayi2 > sayi1) {
        println("Buyuk sayi: $sayi2")
        println("Kucuk sayi: $sayi1")
    } else {
        println("Sayilar esittir.")
    }

}
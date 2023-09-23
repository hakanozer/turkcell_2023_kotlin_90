package com.tutkuzdmr.odev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Scanner

/*
 Kullanıcıdan 3 Haneli Bir Sayı
	Alıyorsunuz. Bu Sayının
	Rakamlarını Tersten Yazdırıyorsunuz
 */

fun main() {

    val scanner = Scanner(System.`in`)

    println("uc basamakli bir sayi girin:")

    val sayi = scanner.next()

    if (sayi.length != 3) {
        println("3 basamakli bir sayi girin.")
    }

    else {

        val tersSayi = sayi.reversed()

        println("Rakamlari tersten yazilmis hali: $tersSayi")
    }
}



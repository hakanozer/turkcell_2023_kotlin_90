package com.tutkuzdmr.odev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Scanner

/* Kullanıcıdan 3 Haneli Bir Sayı
	Alıyorsunuz. Bu Sayının
	Basamaklarının Toplamını
	Yazdırıyorsunuz
 */

fun main() {

    val scanner = Scanner(System.`in`)

    println("3 basamak bir sayi girin:")
    val sayi = scanner.next()

    if (sayi.length != 3) {
        println("Lutfen 3 basamakli bir sayi girin.")
        return
    }
    else {
        val basamaklarinToplami = sayi.map { it.toString().toInt() }.sum()

        println("Basamaklarin toplami: $basamaklarinToplami")
    }
}

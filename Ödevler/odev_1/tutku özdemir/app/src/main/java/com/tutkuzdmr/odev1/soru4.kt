package com.tutkuzdmr.odev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Scanner

}
fun main(args: Array<String>){

    val scanner = Scanner(System.`in`)

    println("Bir N sayisi girin:")
    val n = scanner.nextInt()

    if (n < 1) {
        println("Pozitif bir sayi girin.")
    } else {
        val toplam = Hesapla(n)
        println("1'den $n'e kadar olan sayıların toplamı: $toplam")
    }

}

fun Hesapla(n: Int): Int {
    return n * (n + 1) /


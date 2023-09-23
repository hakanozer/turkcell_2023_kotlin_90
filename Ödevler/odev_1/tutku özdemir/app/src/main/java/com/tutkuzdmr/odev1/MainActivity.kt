package com.tutkuzdmr.odev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Scanner

// 1 - Kullanıcıdan 3 Kenar Değeri Alıyorsun
//Bu 3 Değerden Üçgen Yapılıp Yapılamayacağını
//Test Edip Sonucu Bastıracaksınız
//Her 2 Kenarın Toplamı Diğer 3. Kenara Eşit/Fazlaysa Üçgen Olur



fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    println("1.kenar degerini giriniz:")
    val kenar1 = scanner.nextInt()

    println("2.kenar degerini giriniz:")
    val kenar2 = scanner.nextInt()

    println("3.kenar degerini giriniz:")
    val kenar3 = scanner.nextInt()

    val ucgen = ucgenKontrol(kenar1, kenar2, kenar3)

    if(ucgen) {
        println("ucgen yapilabilir.")
    }
    else{
        println("ucgen yapilamaz.")
    }
}

fun ucgenKontrol(a: Int ,b: Int ,c: Int ): Boolean {
    return (a + b >= c) && (a + c >= b) && (b + c >= a)
}
package com.works.odevler

import java.io.File
import java.util.Random

/**
 * #2. 1. Sorudaki Dosyayı -1000, +1000 Arası 500 Tane Random Sayıyla Dolduran Bir Uygulama Yazın.
 */

fun main(args: Array<String>) {
    val dosyaAdi = "sayılar.txt"
    val dosya = File(dosyaAdi)

    val random = Random()
    val yazici = dosya.bufferedWriter()

    val sayilar = 500
    val min = -1000
    val max = 1000
    for (item in 1..sayilar){
        val rasgeleSayi = random.nextInt(max - min) + min
        yazici.write(rasgeleSayi.toString())
        yazici.newLine()
    }
    yazici.close()
    println("$sayilar adet sayı eklendi")

}
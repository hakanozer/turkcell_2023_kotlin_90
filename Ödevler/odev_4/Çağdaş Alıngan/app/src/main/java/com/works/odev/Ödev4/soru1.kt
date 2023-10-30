package com.works.odev.Ödev4

import java.util.Random

/**
 * 1. 1-49 Arası, 6 Farklı Sayı Seçip Gösterecek Bir Uygulama Yapın
 */
fun main(args: Array<String>) {


    val numaralar = mutableSetOf<Int>()


for (item in 1..49) {
val sayi = Random()
numaralar.add(sayi.nextInt(6))
}
    println(numaralar)




}
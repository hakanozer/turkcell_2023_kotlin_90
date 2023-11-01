package com.works.turkcellodevler.Odev_4

import kotlin.random.Random

/*
1. 1-49 Arası, 6 Farklı Sayı Seçip Gösterecek Bir Uygulama Yapın
 */

fun main(args: Array<String>) {

    val random = Random
    val selectedNumber = mutableListOf<Int>()

    while (selectedNumber.size < 6){
        val randonNum = random.nextInt(1,49)
        selectedNumber.add(randonNum)
    }

    println("Rastgele seçilen 6 sayı: $selectedNumber")

}


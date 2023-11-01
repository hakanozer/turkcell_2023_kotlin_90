package com.works.turkcellodevler.Odev_4

/*
11. Bir List içinde rastgele sayılar bulunsun.
Bu sayıları büyükten küçüğe sıralayarak sıralama işlemini gerçekleştiren bir Kotlin işlevi yazın.
 */

fun main(args: Array<String>) {

    val list = listOf(99,52,4,57,44,21,1,31,18)
    val sorted = list.sorted()

    println(sorted)

}
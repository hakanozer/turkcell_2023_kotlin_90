package com.works.odev.Ödev4

/**
 *11. Bir List içinde rastgele sayılar bulunsun. Bu sayıları
 *büyükten küçüğe sıralayarak sıralama işlemini gerçekleştiren bir Kotlin işlevi yazın.
 */
fun main(args: Array<String>) {
    val liste = listOf<Int>(1,77,8,4,55,22,17,11,27,12,9,7,10)

    val sirala = liste.sortedDescending()

    println("Büyükten küçüğe sıralama : $sirala")
}

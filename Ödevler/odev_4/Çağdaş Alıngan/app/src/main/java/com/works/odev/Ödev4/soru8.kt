package com.works.odev.Ödev4

/**
 *8. Bir List'teki tüm elemanların toplamını hesaplayan bir Kotlin işlevi yazın.
 *  Ayrıca, bu işlevin sadece pozitif sayıları dikkate almasını sağlayın.
 */
fun main(args: Array<String>) {
    val liste = listOf<Int>(1,7,15,-20,5,-3,11)

    var toplam = 0

    for (item in liste){
        if (item > 0){
            toplam += item
        }
    }
    println("Toplam : $toplam")
}
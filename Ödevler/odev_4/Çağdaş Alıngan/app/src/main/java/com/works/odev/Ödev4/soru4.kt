package com.works.odev.Ödev4

/**
 * 4.Bir Kotlin List oluşturun ve bu listede bulunan elemanları ekrana
 * yazdırmak için bir döngü kullanarak her elemanı dolaşan bir program yazın.
 */
fun main(args: Array<String>) {
    val liste = listOf("İzmir", "İstanbul", "Ankara", "Adana", "Antalya")

    liste.forEach{item ->
        println(item)
    }
}
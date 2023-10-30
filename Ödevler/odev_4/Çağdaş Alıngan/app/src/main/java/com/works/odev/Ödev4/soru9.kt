package com.works.odev.Ödev4

/**
 * 9. Bir List içinde null değerler de dahil olmak üzere karmaşık veriler bulunduğunu varsayalım.
 * Bu verileri filtreleyerek null olmayan elemanları yeni bir List'e ekleyen bir işlev yazın.
 */
fun main(args: Array<String>) {

    val liste = listOf<Any?>(null,1,7,"Ali")

    val newList = liste.filterNotNull()

    println("Yeni liste : $newList")
}
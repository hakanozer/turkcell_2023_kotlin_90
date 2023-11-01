package com.works.turkcellodevler.Odev_4

/*
9. Bir List içinde null değerler de dahil olmak üzere karmaşık veriler bulunduğunu varsayalım.
Bu verileri filtreleyerek null olmayan elemanları yeni bir List'e ekleyen bir işlev yazın.
 */
fun main(args: Array<String>) {

    val list = listOf(9, "Hatay", null, 31, "Ankara", 6, null, 18)
    val filteredList = filterNonNullElements(list)
    println(filteredList)

}

fun filterNonNullElements(list: List<Any?>): List<Any> {
    return list.filterNotNull()
}
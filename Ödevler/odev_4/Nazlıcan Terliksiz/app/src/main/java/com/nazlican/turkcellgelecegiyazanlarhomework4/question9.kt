package com.nazlican.turkcellgelecegiyazanlarhomework4

fun filterNonNullValues(list: List<Any?>): List<Any> {
    return list.filterNotNull()
}

fun main() {
    val list = listOf("Kotlin", 3, null, "Java", 3.14, null, "Python", null, 7)
    val filteredList = filterNonNullValues(list)
    println("Null olmayan elemanlar:")
    filteredList.forEach { println(it) }
}
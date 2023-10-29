package com.works.homework4


class Soru9 {
    fun filterNonNullElements(dataList: List<Any?>): List<Any> {
        return dataList.filterNotNull()
    }
}


fun main() {
    val data = listOf(44, null, "Merhaba", 123.45, null, 'A', "null")

    val filter = Soru9()
    val nonNullData = filter.filterNonNullElements(data)

    println("Null olmayan veriler:")
    nonNullData.forEach { println(it) }
}

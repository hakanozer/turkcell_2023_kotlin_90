package com.works.homework4

class Soru5 {
    fun mergeSetAndList(set: Set<String>, list: List<String>): List<String> {
        val mergedList = mutableListOf<String>()
        list.forEach { element ->
            if (!mergedList.contains(element)) {
                mergedList.add(element)
            }
        }
        set.forEach { element ->
            if (!mergedList.contains(element)) {
                mergedList.add(element)
            }
        }
        return mergedList
    }
}


fun main() {
    val set = setOf("2", "3", "6","8","9")
    val list = listOf("1", "2", "3","4","8")

    val setListMerger = Soru5()
    val mergedList = setListMerger.mergeSetAndList(set, list)

    println("Birleştirilmiş Liste:")
    mergedList.forEach { println(it) }
}

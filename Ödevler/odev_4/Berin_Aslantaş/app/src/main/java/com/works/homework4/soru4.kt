package com.works.homework4


class Soru4 {
    fun printListElements(list: List<String>) {
        for (element in list) {
            println(element)
        }
    }
}


fun main() {
    val myList = listOf("Eleman 1", "Eleman 2", "Eleman 3", "Eleman 4", "Eleman 5")

    val listPrinter = Soru4()
    listPrinter.printListElements(myList)
}

package com.works.turkcell._13_collections

fun main(args: Array<String>) {

    // mutableListOf
    // Bir dizinin runtime halinde diziye ekleme, silme gibi davranışlarlarla
    // hakimiyet sağlama biçimidir.

    val arr = mutableListOf<String>()
    val cities = listOf<String>("Gaziantep", "Malatya", "Samsun")


    // add item
    arr.add("İstanbul")
    arr.add("İzmir")
    arr.add("Adana")
    arr.add("Antalya")
    arr.add("Bursa")

    // add index item
    arr.add(1, "Ankara")

    // addAll
    arr.addAll(5, cities)

    // get item
    try {
        val item = arr.get(110)
        println(item)
    }catch (ex:Exception) {}

    val index = 110
    if (index < arr.size) {
        val item = arr.get(index)
        println(item)
    }

    // item delete
    arr.removeAt(0)
    arr.remove("Adana")
    arr.removeFirst()


    println(arr)

}

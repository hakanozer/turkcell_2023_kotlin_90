package com.works.turkcell._13_collections

import java.util.*

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
    arr.add(" ")
    arr.add(" ")
    arr.add(" ")

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

    // replaceAll
    Collections.replaceAll(arr, " ", "Empty!")
    arr.replaceAll{ it -> it.uppercase() }
    //arr.replaceAll { it -> it.replace(" ","Empty!").uppercase() }

    arr.set(6, "ŞanlıUrfa")

    arr.removeIf {
        it -> !it.lowercase().contains("a")
    }
    println(arr)

    val list = dataResult()
    val start = System.currentTimeMillis()
    list.parallelStream().forEach {
        Thread.sleep(1)
        println(it)
    }
    val end = System.currentTimeMillis()
    val between = end - start
    println("End Time - $between")

}

fun dataResult() : MutableList<String>  {
    val arr = mutableListOf<String>()
    for ( i in 0..20000 ) {
        arr.add("item-$i")
    }
    return arr
}

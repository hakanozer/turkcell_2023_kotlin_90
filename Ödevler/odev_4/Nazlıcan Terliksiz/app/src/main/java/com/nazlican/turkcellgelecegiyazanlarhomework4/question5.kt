package com.nazlican.turkcellgelecegiyazanlarhomework4

fun main() {
    val mySet = setOf("elma", "portakal", "muz", "şeftali", "potakal")
    val myList = listOf("elma", "muz", "portakal", "şeftali", "portakal")

    val combinedCollection = mySet.union(myList)
    println("Birleştirilmiş Koleksiyon:")
    combinedCollection.forEach { println(it) }
}
package com.works.turkcell._13_collections

fun main(args: Array<String>) {

    // Set
    // İçerisinde benzersiz değerler, object'ler tutmak için kullanılır.
    val arr = mutableListOf<String>()
    arr.add("İstanbul")
    arr.add("İstanbul")
    arr.add("İstanbul")
    arr.add("Bursa")
    arr.add("Bursa")
    arr.add("izmir")
    arr.add("Adana")
    arr.add("Adana")
    arr.add("Adana")
    arr.add("Antalya")
    arr.add("Antalya")
    arr.add("Malatya")
    println(arr)

    val arrSet = mutableSetOf<String>()
    arrSet.add("İstanbul")
    arrSet.add("İstanbul")
    arrSet.add("İstanbul")
    arrSet.add("Bursa")
    arrSet.add("Bursa")
    arrSet.add("izmir")
    arrSet.add("Adana")
    arrSet.add("Adana")
    arrSet.add("Adana")
    arrSet.add("Antalya")
    arrSet.add("Antalya")
    arrSet.add("Malatya")
    println(arrSet)


    val arrSetObj = mutableSetOf<Note>()

    val n1 = Note()
    val n2 = Note()
    val n3 = Note()

    n3.name = "Kaan"

    arrSetObj.add(n1)
    arrSetObj.add(n1)
    arrSetObj.add(n2)
    arrSetObj.add(n2)
    arrSetObj.add(n2)
    arrSetObj.add(n3)
    arrSetObj.add(n3)
    arrSetObj.add(n3)
    arrSetObj.add(n3)
    arrSetObj.add(Note())

    arrSetObj.removeIf{
        it -> it.name === "Kaan"
    }

    arrSetObj.forEach {
        println(it.name)
    }


    println(arrSetObj)

}
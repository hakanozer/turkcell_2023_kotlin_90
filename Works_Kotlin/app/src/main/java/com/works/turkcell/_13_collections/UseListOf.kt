package com.works.turkcell._13_collections

fun main(args: Array<String>) {

    // ListOf
    // ImMutable array türleridir.
    // Normal bir dizi(Array) yapısına göre daha gelişmiş bir ortam sunar.
    var list1 = listOf<String>("Ankara","Adana","Antalya","İzmir")
    println( list1.get(0) )
    var status = list1.contains("Adana")
    var index = list1.indexOf("Adana")
    println(status)
    println(index)

}
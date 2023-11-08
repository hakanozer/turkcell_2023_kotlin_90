package com.works.fifthassignment._5_InterAndPoly

fun main(args: Array<String>) {
    val hayvanlar: List<Hayvan> = mutableListOf(
        Kedi("esneklik", "miyav",4,"Kedi"),
        Guvercin("uçabilme", "yok", 2, "Güvercin")
    )

    for(hayvan in hayvanlar) {
        println("-------------${hayvan.ad}--------------")
        hayvan.ozelliklerim()
    }
}
package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru12 {
    private fun ortakElemanlariBul(set1: Set<Any>, set2: Set<Any>): Set<Any> {
        return set1.intersect(set2)
    }
    fun ortakEleman() {
        val set1 = setOf("a", "b", "c", "d","e","f")
        val set2 = setOf("c", "d", "e", "f","g","h")
        val ortakElemanlar = ortakElemanlariBul(set1, set2)
        println("Ortak elemanlar: $ortakElemanlar")
    }
}
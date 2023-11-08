package com.works.homework5.Polymorphism


interface SesCikarabilen {
    fun sesCikar()
}


class Kuş : SesCikarabilen {
    override fun sesCikar() {
        println("Cikcik!")
    }
}

class Ördek : SesCikarabilen {
    override fun sesCikar() {
        println("Vakvak!")
    }
}

fun main() {
    val hayvanlar = listOf(Kuş(), Ördek())

    for (hayvan in hayvanlar) {
        hayvan.sesCikar()
    }
}
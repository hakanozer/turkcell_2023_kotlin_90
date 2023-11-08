package com.works.homework5.InheritanceVePolymorphism

open class Hayvan(val isim: String) {
    open fun sesCikar() {
        println("$isim bir hayvandır.")
    }
}

class Köpek(isim: String) : Hayvan(isim) {
    override fun sesCikar() {
        println("$isim bir köpek ve havlıyor.")
    }
}

class Kedi(isim: String) : Hayvan(isim) {
    override fun sesCikar() {
        println("$isim bir kedi ve miyavlıyor.")
    }
}

fun main() {
    val hayvanlar = arrayOf(Hayvan("xxxxxx"), Köpek("Rıfkı"), Kedi("Mathilda"))

    for (hayvan in hayvanlar) {
        hayvan.sesCikar()
    }
}

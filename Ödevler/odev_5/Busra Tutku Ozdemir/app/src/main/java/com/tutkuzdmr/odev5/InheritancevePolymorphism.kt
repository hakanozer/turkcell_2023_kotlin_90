package com.tutkuzdmr.odev5


open class Hayvan(val ad: String) {
    open fun sesCikar() {
        println("$ad ses çıkarıyor")
    }
}

class Kopek(ad: String) : Hayvan(ad) {
    override fun sesCikar() {
        println("$ad havlıyor")
    }
}

class Kedi(ad: String) : Hayvan(ad) {
    override fun sesCikar() {
        println("$ad miyavlıyor")
    }
}

fun main() {
    val karabas = Kopek("Karabaş")
    val pamuk = Kedi("Pamuk")

    val hayvanlar: Array<Hayvan> = arrayOf(karabas, pamuk)

    for (hayvan in hayvanlar) {
        hayvan.sesCikar()
    }
}
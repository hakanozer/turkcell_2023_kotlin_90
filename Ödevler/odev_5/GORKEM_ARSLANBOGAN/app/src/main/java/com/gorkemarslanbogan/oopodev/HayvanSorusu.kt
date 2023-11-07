package com.gorkemarslanbogan.oopodev


open class Hayvan(val cins: String, yas: Int){
    open fun konus() {
        println("Hayvan ses çıkarmıyor.")
    }
}

class Kedi(cins: String, yas: Int) : Hayvan(cins, yas) {
    override fun konus() {
        println("$cins miyavlıyor.")
    }
}

class Kopek(cins: String, yas: Int) : Hayvan(cins, yas){
    override fun konus() {
        println("$cins, havlıyor.")
    }
}


fun main(args: Array<String>) {
    val hayvanlar = listOf(
        Kedi("Boncuk", 3),
        Kopek("Pamuk", 2),
        Kedi("Mavi", 4)
    )
    for (hayvan in hayvanlar) {
        println("${hayvan.cins} isimli hayvan: ")
        hayvan.konus()
    }
}
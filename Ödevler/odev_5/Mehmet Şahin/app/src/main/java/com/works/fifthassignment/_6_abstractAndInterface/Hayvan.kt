package com.works.fifthassignment._6_abstractAndInterface


abstract class Hayvan {
    abstract fun familya()
}

interface IUcma {
    fun ucma()
}
//abstractan farklı olarak interfacede "()" kullanılmaz
class Sahin() : Hayvan(), IUcma {
    override fun familya() {
        println("Ben bir yırtıcıyım")
    }

    override fun ucma() {
        println("Ben uçabilirim")
    }

}

fun main(args: Array<String>) {
    val sahin = Sahin()
    sahin.familya()
    sahin.ucma()
}
package com.works.turkcellodevler.Odev_5.Soru_03

fun main(args: Array<String>) {

    val hayvanlar: Array<Hayvan> = arrayOf(Kopek(), Kedi())

    for (hayvan in hayvanlar) {
        hayvan.sesCikar()
    }

}
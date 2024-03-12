package Soru5

fun main(args: Array<String>) {
    val hayvanlar = arrayOf(Hayvan("HayvanınTürü"), Köpek("Kurt"), Kedi("British"))

    for (hayvan in hayvanlar) {
        println("${hayvan.ad}: ")
        hayvan.sesCikar()
    }
}
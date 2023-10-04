package com.works.odevler



/**
 * parametre olarak verilen long sayisinin
 * rakamlarinin toplamını döndüren methodu
 * yazin
 */

fun main(args: Array<String>) {

    val b : Long = 14565788L
    val sonuc = topla(b)
    println("sayının rakamları toplamı : $sonuc")
}

fun topla(a:Long):Long{

    var toplam : Long = 0
    var rakam : Long = a

    while (rakam != 0L){
        val kalan : Long = rakam%10
        toplam += kalan
        rakam /= 10

    }


return toplam

}
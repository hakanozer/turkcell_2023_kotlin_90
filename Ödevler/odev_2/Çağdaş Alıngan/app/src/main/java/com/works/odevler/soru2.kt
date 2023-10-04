package com.works.odevler
/**
2 - Parametre olarak 2 int sayı alan,
bu sayilarin (ilki hariç, 2.si dahil olmak
üzere) toplamlarını döndüren bir method
yazın
 */
fun main(args: Array<String>) {


    fnc(4,9)

}

fun fnc(a: Int , b: Int) {

    val liste = arrayListOf<Int>()

    for (toplam in a+1..b){

        liste.add(toplam)

    }
    println(liste.sum())
}
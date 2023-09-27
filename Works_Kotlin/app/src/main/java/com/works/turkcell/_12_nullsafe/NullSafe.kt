package com.works.turkcell._12_nullsafe

import java.util.*

fun main(args: Array<String>) {

    // Nullable Types -> Optional Type
    // Bir değişken yada nesnenin null olabilme ihtimaline denir.
    val name:String? = null
    var surname = "Bilmem"
    // surname = null
    try {
        println( name!!.length )
        // Null denetimi farklı yazım şekli
        name.let {
            it.length
        }
    }catch (ex: Exception) {}

    if (name != null) {
        name.length
    }

    // is
    // bir objenin(Any) içinde beklenen object türünün olup olmadığını kontrol eder.
    val strNum = "101"
    //if ( strNum is Int ) { }
    var strObj: Any = "101"
    strObj = 100
    strObj = false
    if ( strObj is Boolean ) {
        println(strObj)
        println("strObj Boolean")
    }

    // elvis (?:)
    // null olan bir objectin default değerini atmak için kullanılır.
    // bir nevi bir if denetimi vardır.
    val city:String? = null
    val address:String? = " Beşiktaş No:2 "

    var stx = ""
    if (city == null){
        stx = ""
    }else {
        stx = city.trim()
    }
    val st1 = city?.trim() ?: ""
    val st2 = address?.trim() ?: ""
    println("st1 : $st1")
    println("st2 : $st2")

    val a:Int? = 10
    val b:Int? = null

    val c = (a?.toInt() ?:0) + (b?.toInt() ?: 0)
    println("Sum : $c")

}
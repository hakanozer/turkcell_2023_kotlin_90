package com.works.turkcell._6_when

fun main(args: Array<String>) {

    // when
    val day = "Salı"

    if ( day.equals("Pazartesi") ) {
        println("Gün Pazartesi")
    }else if ( day.equals("Salı") ) {
        println("Gün Salı")
    }else if ( day.equals("Çarşamba") ) {
        println("Gün Çarşamba")
    }else {
        println("Gün Hatalı!")
    }

    val constData = when(day) {
        "Pazartesi" -> "Gün Pazartesi"
        "Salı" -> "Gün Salı"
        "Çarşamba" -> "Gün Çarşamba"
        else -> "Gün Hatalı!"
    }
    println(constData)

    val returnData = when(day) {
        "Pazar", "Pazartesi", "Salı" -> "Şart 1 - Sağlandı"
        "Çarşamba", "Perşembe", "Cuma" -> "Şart 2 - Sağlandı"
        else -> "Hiç bir şart sağlanmıyor"
    }
    println(returnData)


}
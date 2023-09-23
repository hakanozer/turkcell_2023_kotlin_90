package com.works.turkcell._5_if

fun main(args: Array<String>) {

    val city = "Hatay"
    val code = "Kotlin"
    val end = if ( city.equals("Hatay") && code.equals("Kotlin") ) {
        "Code :$code and City: $city"
    }else {
        "Not found!"
    }
    println(end)

    var status = false
    if (!status) {
        println("if true")
    } else {
        println("if false")
    }

    var result = if ( city.equals("Hatayx") && code.equals("Kotlin") ) "Success" else "Fail"
    println(result)

}
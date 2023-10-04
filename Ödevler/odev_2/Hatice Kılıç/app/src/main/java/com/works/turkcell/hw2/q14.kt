package com.works.turkcell.hw2

fun main(args: Array<String>) {
    val num = bolmeIslemi(-4,0)
    println("$num")
}

fun bolmeIslemi(a:Int, b:Int):Double{
    var sonuc = 0.0
    val number1 = a.toDouble()
    val number2 = b.toDouble()
    try {
        if ( b == 0 ){
            println("Bolme islemi sifira bolunemez")
        }
        if( a == 0){
            println("0")
        }
        else{
            sonuc = number1 / number2
        }
    }catch(ex:NumberFormatException){
        println(ex.message)
    }
    return  sonuc
}
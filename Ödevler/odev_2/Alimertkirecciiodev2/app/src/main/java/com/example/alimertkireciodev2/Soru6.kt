package com.example.alimertkireciodev2
//6 - parametre olarak verilen int sayinin
//tersten yazilmiş halini int olarak döndüren
//bir method yazin
fun reversed(sayı:Int):Int{
    return sayı.toString().reversed().toInt()

}
fun main(args: Array<String>) {
var deger= reversed(4187)
    println(deger)
}
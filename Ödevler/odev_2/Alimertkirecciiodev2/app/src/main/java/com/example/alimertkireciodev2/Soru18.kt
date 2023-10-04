package com.example.alimertkireciodev2

fun main(args: Array<String>) {
    try{

        println("Birinci değer=")
        var deger1= readLine()!!.toInt()
        println("İkinci değer=")
        var deger2= readLine()!!.toInt()
        var sonuc=deger1*deger2
        println(sonuc)
        deger1
    }
    catch (ex:Exception){
        println("Hatalı Değer girdiniz!")
    }
}














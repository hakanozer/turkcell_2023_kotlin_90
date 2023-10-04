package com.works.turkcell.hw2

fun main(args: Array<String>) {
    println("Lutfen string bir ifade giriniz")
    val str1 = readLine()

    println("Lutfen ikinci bir string ifade giriniz")
    val str2 = readLine()

    try {
        if ( str1?.length !== str2?.length ?: String )
            println("Karakter sayilari uyusmuyor")
        else{
            println("Karakter sayilari esit")
        }
    }catch (ex:Exception){
        println("Lutfen yeni degetekrar deneyiniz")
    }
}
package com.works.turkcell.hw2

fun main(args: Array<String>) {

    println("Lutfen 4 basamakli bir sayi giriniz ")
    val num = readLine()

    try {
        val number = num?.toInt() ?: throw NumberFormatException ("Gecerli bir sayi giriniz")
        if (number in 1000..9999){
            if (number % 2 == 0){
                println("Girilen sayinin 2 ile bolumunden kalan sifirdir.")
            }else {
                println("Girilen sayi 2 ile tam bolunemez.")
            }
        }else{
            println("Girilen sayi 4 basamakli degildir")
        }

    }catch (ex:Exception){
        println(ex.message)
    }

}
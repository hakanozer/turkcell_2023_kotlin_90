package com.works.turkcell.hw2

//Bir kullanıcıdan alınan metin verisini tamsayıya
//dönüştüren bir kotlin prgoramı yazınız
fun main(args: Array<String>) {

    println("Lutfen bir metin giriniz")
    val metin = readLine()
    try {
        val size = metin?.length
        println(size)
    }catch (ex:Exception){
        ("Lutfen metin olusturunuz")
    }


}
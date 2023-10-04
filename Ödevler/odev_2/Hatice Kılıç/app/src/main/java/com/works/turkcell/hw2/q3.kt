package com.works.turkcell.hw2

fun main(args: Array<String>) {

    val num = numbers(8,0)
    println("$num")
}
fun numbers(a:Int, b:Int):Double{
    var sonuc = 0.0
    val number1 = a.toDouble()
    val number2 = b.toDouble()
    try {
        if ( b == 0 ){
            println("Bolen sayi sifir olamaz")
        }
        if (a % 2 == 0 ){
            sonuc = number1 % number2
        }else{
            sonuc = number1 / number2
        }
    }catch(ex:Exception){
        println("Lutfen integer iki sayi giriniz")
    }
    return  sonuc
}





package com.works.turkcell.hw2

fun main(args: Array<String>) {

    val summ = sum(1,3)
    println("Sum : $summ")

}
fun sum(number1:Int, number2:Int) : Int{
    var sum = 0
    if (number1 > number2 && number1 > 0 && number2 > 0){
        for (i in number2+1..number1)
            sum += i
    }else if (number2 > number1 && number2 > 0 && number1 > 0){
        for (i in number1+1..number2)
            sum += i
    }else{
        println("Lutfen gecerli sayi degerli giriniz")
    }
    return  sum

}
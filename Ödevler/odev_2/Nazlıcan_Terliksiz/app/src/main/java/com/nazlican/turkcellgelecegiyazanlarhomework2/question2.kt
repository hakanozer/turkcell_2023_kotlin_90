package com.nazlican.turkcellgelecegiyazanlarhomework2

//Parametre olarak 2 int sayı alan,
//bu sayilarin (ilki hariç, 2.si dahil olmak
//üzere) toplamlarını döndüren bir method
//yazın

fun main(){

    sum(1,5)
}

fun sum(number1:Int,number2:Int){
    var sum = 0
    for(i in number1 + 1..number2){
        sum += i
    }
    println(sum)
}
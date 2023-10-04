package com.works.turkcell.hw2

fun main(args: Array<String>) {
   val totalNumber = minAndMax(intArrayOf(1,5,10,8))
    println("$totalNumber")
}
fun minAndMax(number :IntArray):Int{
    var total: Int
    var minNumber = number[0]
    var maxNumber = number[0]
    for (item in number){
        if (item > maxNumber){
            maxNumber = item
        }
        if (item < minNumber){
            minNumber = item
        }
    }
    total = minNumber + maxNumber
    return  total
}

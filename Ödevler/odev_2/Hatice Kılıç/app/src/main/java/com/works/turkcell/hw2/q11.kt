package com.works.turkcell.hw2

fun main(args: Array<String>) {

    val commonsum = commonEleman(intArrayOf(7,9,0), intArrayOf(5,7,9))
    println("$commonsum")
}
fun commonEleman (array1: IntArray, array2: IntArray): Int{
    var common = 0
    if (array1.isNotEmpty() && array2.isNotEmpty()){
        for (number1 in array1)
            for (number2 in array2){
                if (number1 == number2){
                    common++
                    break
                }
            }

    }
    return common
}
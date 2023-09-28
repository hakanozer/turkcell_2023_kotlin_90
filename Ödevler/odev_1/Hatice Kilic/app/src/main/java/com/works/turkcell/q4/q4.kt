package com.works.turkcell.q4

import java.util.Scanner

fun main(args: Array<String>) {

    val sumnum = nsum()

}
// 1'den n`e kadar sayilarin toplam formulu N = n.(n+1)/2
fun nsum():Int {
    var i = 1
    var sumnum = 0
    val scanner = Scanner(System.`in`)
    println("Lutfen bir sayi giriniz ")
    val n = scanner.nextInt()

    var isBreak = false
    for (i in 1..n){
        var num = n * (n + 1)
        var sumnum = num / 2
        println("sumnum: $sumnum")
        if (i == num){
            isBreak = true
            break
        }
        return sumnum

    }
    return sumnum
}


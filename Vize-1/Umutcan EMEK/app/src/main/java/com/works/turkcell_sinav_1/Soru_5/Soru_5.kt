package com.works.turkcell_sinav_1.Soru_5

import java.util.Scanner

/*
5.	Parametre olarak aldığı sayıyı asal mı diye kontrol edip, sayı asal ise true, değilse false
döndüren isPrime methodunu yazın.
 */

fun main(args: Array<String>) {

    val num = 8
    isPrime(num)

}
fun isPrime(num: Int): Int {
    var count = 0

    if (num <= 1){
        println("Girilen sayı asal değildir.")
    }else{
        for (i in 2..num - 1){
            if (num % i == 0){
                count++
                break
            }
        }
        if (count == 0){
            println("Girilen sayı asaldır.")
        }else{
            println("Girilen sayı asal değildir.")
        }
    }

    return count
}
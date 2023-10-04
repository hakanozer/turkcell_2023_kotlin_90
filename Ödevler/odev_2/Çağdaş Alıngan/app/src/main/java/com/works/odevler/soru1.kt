package com.works.odevler


/**
1 - Parametre olarak aldığı sayıyı
asal mı diye kontrol edip,
sayı asal ise true, değilse false döndüren
isPrime methodunu yazın

public static boolean isPrime(int n)
 */
fun main(args: Array<String>) {

    val status = isPrime(173)
    println(status)
}

fun isPrime(n:Int) : Boolean{
    if (n <= 1){
       return false
    }
    if (n <= 3){
        return true
    }
    if (n %2 == 0 || n %3 == 0){
        return false
    }

    var b = 5
    if (b * b <= n){
        if (n % b == 0 ){
            return false
        }
        b += 6
    }
    return true
}
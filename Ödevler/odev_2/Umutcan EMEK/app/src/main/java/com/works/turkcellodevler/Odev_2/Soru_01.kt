package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
1 - Parametre olarak aldığı sayıyı
asal mı diye kontrol edip,
sayı asal ise true, değilse false döndüren
isPrime methodunu yazın

public static boolean isPrime(int n)
 */

fun main(args: Array<String>) {

    isPrime()

}
fun isPrime(): Int {
    var count = 0

    try {
        print("Kontrol edilecek sayıyı giriniz:")
        val scanner = Scanner(System.`in`)
        val num = scanner.nextInt()
        if (num <= 1){
            println("Girdiğiniz sayı asal değildir.")
        }else
        {
            for (i in 2..num - 1){
                if (num % i == 0){
                    count++
                    break
                }
            }
            if (count == 0){
                println("Girdiğiniz sayı asaldır.")
            }else{
                println("Girdiğiniz sayı asal değildir.")
            }
        }
    }catch (ex: Exception){
        println("Lütfen sadece tam sayı giriniz.")
    }

    return count
}



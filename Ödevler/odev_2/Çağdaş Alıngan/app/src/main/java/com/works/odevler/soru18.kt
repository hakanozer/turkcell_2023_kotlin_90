package com.works.odevler

import java.util.Scanner

/**
 * 18- Kullanıcıdan alınan 2 verinin çarpımını bulan bir program yazınız.
 * Verilerin integer olmaması durumunu try-catch
 * bloğu ile kontrol ediniz. (Davut Karakuş)
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    try {
        println("Deger girin!")
        val a = scanner.nextInt()
        println("Deger girin!")
        val b = scanner.nextInt()

        val carp = a*b
        println(carp)

    }catch (ex:Exception){
        println("Lütfen tam sayı giriniz")
    }finally {
        println("Kotlin eğlenceli")
    }


}
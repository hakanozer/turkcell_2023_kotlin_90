package com.works.turkcellodevler.Odev_2

import java.util.Scanner
import kotlin.math.sqrt

/*
23- Try catch kullanarak kullanıcının girdiği bir
sayının karekökünü hesaplayan program yazınız.
Negatif sayı girilmediğinden emin olunuz.(Büşra Tutku Özdemir)
 */

fun main(args: Array<String>) {

    try {
        print("Karakökünü girmek istediğiniz sayıyı giriniz: ")
        val scanner = Scanner(System.`in`)
        val num = scanner.nextInt()
        val result = sqrt(num.toDouble())
        println(result)
    }catch (ex: Exception){
        println("Lütfen negatif sayı ve sayı dışında bir şey girmediğininzden emin olunuz.")
    }

}
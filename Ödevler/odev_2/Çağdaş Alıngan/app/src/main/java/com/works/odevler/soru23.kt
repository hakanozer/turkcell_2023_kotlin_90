package com.works.odevler

import java.lang.RuntimeException
import java.util.Scanner
import kotlin.math.sqrt

/**
 * 23- Try catch kullanarak kullanıcının girdiği bir
  * sayının karekökünü hesaplayan program yazınız.
  * Negatif sayı girilmediğinden emin olunuz.(Büşra Tutku Özdemir)
 */
fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    try {
        println("Tamsayı giriniz")
        val n = scanner.nextInt()

        if (n<0){
            println("lütfen negatif değer girmeyiniz")
        }else{
        val karekok = sqrt(n.toDouble())
        println(karekok)
        }


    }catch (ex:Exception){
            println("Lütfen metin değeri girmeyiniz !")
    }
}
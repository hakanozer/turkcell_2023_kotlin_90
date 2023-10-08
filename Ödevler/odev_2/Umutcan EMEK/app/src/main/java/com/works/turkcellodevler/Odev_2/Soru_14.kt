package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
14- İki tam sayıyı bölen bir method yazın ve
bölenin sıfır olma durumunu try-catch bloğu ile ele alın.
Eğer bölen sıfır ise "Bölme işlemi sıfıra bölünemez." şeklinde bir hata mesajı döndürsün.
Aksi takdirde sonucu döndürsün. (Eyüp Balcan)
 */

fun main(args: Array<String>) {

    division(8.0,5.0)

}

fun division(num1: Double, num2: Double): Double {
    var result = 0.0
    try {
        result = num1 / num2
        println("Bölme işleminin sonucu: $result")
    }catch (ex: Exception){
        println("Lütfen ilgili bölümlere sayı ve bölen sayı kısmına 0 girmediğinizi kontrol ediniz.")
    }
    return result
}


package com.works.odevler

/**
 *12 - bir sayıyı sıfıra bölmeye çalışırken karşılaşılan bir
 * hata durumunu ele almak için nasıl bir try-catch bloğu oluşturursunuz? (Sefa Satiloglu)
 */
fun main(args: Array<String>) {

    try {
        val bol = 10/0
    }catch (ex:Exception){
        println("hata : ${ex.message}")
    }
}
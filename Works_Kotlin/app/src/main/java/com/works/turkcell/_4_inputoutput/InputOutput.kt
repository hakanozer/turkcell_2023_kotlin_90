package com.works.turkcell._4_inputoutput

fun main(args: Array<String>) {

    // uygulama geliştirme anında kullanıcı varmış gibi kullanıcıdan veri alma biçimidir.
    println("Lütfen boyunuzu(cm) giriniz!")
    val stAge = readLine()
    println("Lütfen kilonuzu giriniz!")
    val stTotal = readLine()

    if (stAge != null && stTotal != null) {
        try {
            val dAge = stAge.toDouble()
            val dTotal = stTotal.toDouble()
            if ( dAge > 260 || dAge < 100 ) {
                println("Boyunuzu doğru giriniz!")
            }else if ( dTotal > 200 || dTotal < 45 ) {
                println("Kilonuzu doğru giriniz!")
            }else {
                val end = dTotal / dAge
                println("end : $end")
            }
        }catch (ex: Exception) {
            println("Hesaplama hatası oluştu, Lütfen sadece sayısal değerler giriniz!")
        }

    }
/*
* bu fonksiyon hesaplama işlemi ile
* birlikte
* */

}

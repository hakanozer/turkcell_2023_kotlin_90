package com.works.turkcellodevler.Odev_2

/*
17- Bir kullanıcıdan alınan metin verisini tamsayıya
dönüştüren bir kotlin prgoramı yazınız. (Keremcan Karakaya)
 */

fun main(args: Array<String>) {

    print("Metin veri giriniz: ")
    val metin = readLine()

    try {
        val tamsayi = metin?.toInt() // veya metin?.toLong() kullanabilirsiniz
        if (tamsayi != null) {
            println("Dönüştürülen tamsayı: $tamsayi")
        } else {
            println("Geçersiz giriş. Lütfen bir tamsayı girin.")
        }
    } catch (e: NumberFormatException) {
        println("Geçersiz giriş. Lütfen bir tamsayı girin.")
    }

}
package com.example.alimertkireciodev2
// Bir kullanıcıdan alınan metin verisini tamsayıya dönüştüren bir kotlin prgoramı yazınız.
fun main(args: Array<String>) {
    println("Lütfen bir String girin:")
    val metin = readLine()
    try {
        val tamsayi: String = metin.toString()
        tamsayi.toInt()

        println("Girdiğiniz tamsayı: $tamsayi")
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir tamsayı girilmedi.")
    }
}
//hocam Ben bu soruyu anlamadım!
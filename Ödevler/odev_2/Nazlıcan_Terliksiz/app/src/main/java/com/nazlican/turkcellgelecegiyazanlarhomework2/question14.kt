package com.nazlican.turkcellgelecegiyazanlarhomework2

//İki tam sayıyı bölen bir method yazın ve
//bölenin sıfır olma durumunu try-catch bloğu ile ele alın.
//Eğer bölen sıfır ise "Bölme işlemi sıfıra bölünemez." şeklinde bir hata mesajı döndürsün.
//Aksi takdirde sonucu döndürsün.

fun main() {
    val sayi = 10
    val bolen = 0

    val sonuc = bol(sayi, bolen)

    if (sonuc is Int) {
        println("Sonuç: $sonuc")
    } else {
        println("Hata: $sonuc")
    }
}
fun bol(sayi: Int, bolen: Int): Any {
    try {
        if (bolen == 0) {
            throw ArithmeticException("Bölme işlemi sıfıra bölünemez.")
        }
        return sayi / bolen
    } catch (e: ArithmeticException) {
        return e.message.toString()
    }
}
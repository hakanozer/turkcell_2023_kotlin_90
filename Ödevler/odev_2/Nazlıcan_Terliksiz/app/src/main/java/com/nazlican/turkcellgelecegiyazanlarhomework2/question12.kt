package com.nazlican.turkcellgelecegiyazanlarhomework2

//bir sayıyı sıfıra bölmeye çalışırken karşılaşılan
// bir hata durumunu ele almak için nasıl bir try-catch bloğu oluşturursunuz?

fun main() {
    val pay = 10
    val payda = 0

    try {
        val sonuc = pay / payda
        println("Sonuç: $sonuc")
    } catch (e: ArithmeticException) {
        println("Hata: Sıfıra bölme hatası")
    }
}

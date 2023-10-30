package com.works.odev.Ödev4

/**
 *10. İçinde metin içeren bir List oluşturun. Bu metinleri uzunluğuna göre sıralayarak en kısa ve en uzun metinleri bulun.
 */

fun main(args: Array<String>) {
    val liste = listOf<String>("Mustafa" , "Kemal" , "Atatürk" , "Cumhuriyetin" , "Yüzüncü" , "Yılı" , "Kutlu" , "Olsun")

    val sirala = liste.sortedBy{ it.length }

    val enKisa = sirala.first()
    val enUzun = sirala.last()

    println("En kısa kelime : $enKisa \nEn uzun kelime : $enUzun")
}

package com.nazlican.turkcellgelecegiyazanlarhomework2

// parametre olarak verilen int sayinin
//tersten yazilmiş halini int olarak döndüren
//bir method yazin

fun main() {
    val tersSayi = tersCevir(12345 )
    println(tersSayi)
}

fun tersCevir(sayi: Int): Int {
    var ters = 0
    var geciciSayi = sayi

    while (sayi != 0) {
        val rakam = geciciSayi % 10
        ters = ters * 10 + rakam
        geciciSayi /= 10
    }
    return ters
}




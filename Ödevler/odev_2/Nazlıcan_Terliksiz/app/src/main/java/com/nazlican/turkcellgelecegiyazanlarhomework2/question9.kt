package com.nazlican.turkcellgelecegiyazanlarhomework2

//parametre olarak bir int[]ve bir sayi
//alan, eğer array sayiyi içeriyorsa true,
//içermiyorsa false döndüren bir method yazin

fun main() {
    val list = arrayListOf(3, 5, 7, 9, 11)
    val arananSayi = 9
    val sonuc = sayiIceriyorMu(list, arananSayi)

    if (sonuc) {
        println("$arananSayi dizi içinde bulunuyor.")
    } else {
        println("$arananSayi dizi içinde bulunmuyor.")
    }
}
fun sayiIceriyorMu(list: ArrayList<Int>, arananSayi: Int): Boolean {
    for (sayi in list) {
        if (sayi == arananSayi) {
            return true
        }
    }
    return false
}
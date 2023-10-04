package com.nazlican.turkcellgelecegiyazanlarhomework2

//parametre olarak verilen int sayinin
//palindrome olup olmadığını test eden
//sonucu boolean olarak döndüren  bir method
//yazın
//
//palindrome : düz ve ters yazılışı aynı
//olan şeyler örn :
//1441 <--> 1441
//ata <--> ata
//1223221 <--> 1223221

fun main() {
    val sayi1 = 1441
    val sonuc1 = isPalindrome(sayi1)

    println("$sayi1 bir palindrome mi? $sonuc1")
}
fun isPalindrome(sayi: Int): Boolean {
    val sayi = sayi.toString()
    val tersSayi = sayi.reversed()
    return sayi== tersSayi
}
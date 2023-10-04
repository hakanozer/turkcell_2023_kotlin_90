package com.works.odevler

/**
 * 7 - parametre olarak verilen int sayinin
 * palindrome olup olmadığını test eden
 * sonucu boolean olarak döndüren  bir method
 * yazın
 */
fun main(args: Array<String>) {
    val sayi = 1232
    val palindromMu = palindrome(sayi)
    if (palindromMu) {
        println("$sayi bir palindrom sayıdır.")
    } else {
        println("$sayi bir palindrom sayı değildir.")
    }
}

fun palindrome(sayi: Int): Boolean {
    val sayiStr = sayi.toString()
    val uzunluk = sayiStr.length
    for (i in 0 until uzunluk / 2) {
        if (sayiStr[i] != sayiStr[uzunluk - 1 - i]) {
            return false
        }
    }
    return true
}



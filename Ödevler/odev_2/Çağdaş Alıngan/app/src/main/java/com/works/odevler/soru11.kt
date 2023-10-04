package com.works.odevler

import java.util.Scanner


/**
 * 11 - kullanıcıdan iki int[] değer alan
 * bu arraylerdeki ortak elemanların
 * sayısını döndüren bir method yazın
 */
//  val dizi1 = intArrayOf(1, 2, 3, 4, 5)
//  val dizi2 = intArrayOf(3, 4, 5, 6, 7)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)


    println("İlk diziyi girin değerler arasında virgül olsun ! : ")
    val dizi1 = scanner.nextLine()
    val array1 = ayir(dizi1)


    println("İkinci dizi girin değerler arasında virgül olsun !: ")
    val dizi2 = scanner.nextLine()
    val array2 = ayir(dizi2)


    val ayniElemanlar = elemanlariSay(array1, array2)
    println("Aynı eleman sayısı: $ayniElemanlar")
}



fun ayir(gir: String): IntArray {
    val degisken = gir.split(",").map { it.trim().toIntOrNull() }
    return degisken.filterNotNull().toIntArray()
}

fun elemanlariSay(array1: IntArray, array2: IntArray): Int {
    val set1 = array1.toSet()
    val set2 = array2.toSet()
    return set1.intersect(set2).size
}





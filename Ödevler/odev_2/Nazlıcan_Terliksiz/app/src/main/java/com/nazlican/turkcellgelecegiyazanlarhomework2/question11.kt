package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.Scanner

// kullanıcıdan iki int[] değer alan
//bu arraylerdeki ortak elemanların
//sayısını döndüren bir method yazın

fun main() {
    val scanner = Scanner(System.`in`)

    print("Birinci dizi boyutunu girin: ")
    val boyut1 = scanner.nextInt()

    val dizi1 = IntArray(boyut1)
    for (i in 0 until boyut1) {
        print("Birinci dizi elemanını girin: ")
        dizi1[i] = scanner.nextInt()
    }

    print("İkinci dizi boyutunu girin: ")
    val boyut2 = scanner.nextInt()

    val dizi2 = IntArray(boyut2)
    for (i in 0 until boyut2) {
        print("İkinci dizi elemanını girin: ")
        dizi2[i] = scanner.nextInt()
    }

    val ortakElemanSayisi = ortakElemanSayisiBul(dizi1, dizi2)
    println("Ortak elemanların sayısı: $ortakElemanSayisi")
}
fun ortakElemanSayisiBul(dizi1: IntArray, dizi2: IntArray): Int {
    val dizi1Set = dizi1.toSet()
    val dizi2Set = dizi2.toSet()

    val ortakElemanlar = dizi1Set.intersect(dizi2Set)

    return ortakElemanlar.size
}
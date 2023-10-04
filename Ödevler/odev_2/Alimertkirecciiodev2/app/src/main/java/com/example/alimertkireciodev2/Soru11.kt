package com.example.alimertkireciodev2
//11 - kullanıcıdan iki int[] değer alan
//bu arraylerdeki ortak elemanların
//sayısını döndüren bir method yazın
fun main() {

    val dizi1 = intArrayOf(22,15,34,41,56)
    val dizi2 = intArrayOf(22,15,34, 6, 7)

    val ortakSayisi = OrtakElemanSayisi(dizi1, dizi2)

    println("Ortak elemanların sayısı: $ortakSayisi")
}

    fun OrtakElemanSayisi(dizi1: IntArray, dizi2: IntArray): Int {
        val dizi1Set = dizi1.toSet()
        val ortakElemanlar = dizi2.filter { eleman -> dizi1Set.contains(eleman) }.toSet()

        return ortakElemanlar.size
    }


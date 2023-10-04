package com.works.odevler

import java.util.Scanner
import kotlin.math.max

/**
 * 10 - kullanıcıdan 4 tane int değer alan,
 * ve en büyük olan değeri geri döndüren bir
 * method yazın
 */
fun main(args: Array<String>) {


    val dizi = arrayListOf<Int>()
    dizi.add(deger())
    val max = dizi.max()
    println("en büyük sayı : $max")



}

fun deger(): Int {
    val scanner = Scanner(System.`in`)

    println(" değeri girin")
    val n1 = scanner.nextInt()
    println(" değeri girin")
    val n2 = scanner.nextInt()
    println(" değeri girin")
    val n3 = scanner.nextInt()
    println(" değeri girin")
    val n4 = scanner.nextInt()

    val dizi = arrayOf(n1,n2,n3,n4)
    var buyuk = 0
    for (sayi in dizi){
        if (sayi > buyuk){
            buyuk = sayi
        }
        }
    return buyuk
    }

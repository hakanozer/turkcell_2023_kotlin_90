package com.works.odevler

/**
 * 8 - parametre olarak verilen int[] deki
 * en büyük ve en küçük sayının toplamını
 * int olarak döndüren method yazın
 */
fun main(args: Array<String>) {


    val dizi = intArrayOf(10,15,7,91,77,2)
    val toplam = buyukKucukToplamı(dizi)
    println("En büyük ve en küçük sayının toplamı: $toplam")
}

fun buyukKucukToplamı(arr: IntArray): Int{

    var enBuyuk = arr[0]
    var enKucuk = arr[0]

    for (item in arr){
        if (item > enBuyuk){
            enBuyuk = item
        }else if (item < enKucuk){
            enKucuk = item
        }
    }
    return enBuyuk + enKucuk
}
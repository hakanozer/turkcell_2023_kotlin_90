package com.example.alimertkireciodev2
//
//8 - parametre olarak verilen int[] deki
//en büyük ve en küçük sayının toplamını
//int olarak döndüren method yazın
fun array(sayilar:IntArray):Int{

    if (sayilar.isEmpty()){
        println("Sayi dizisi boş olamaz")
    }

    var buyuk = sayilar[0]
    var kucuk = sayilar[0]

    for (sayi in sayilar) {
        if (sayi > buyuk) {
            buyuk = sayi
        } else if (sayi < kucuk) {
            kucuk = sayi
        }
    }

    return buyuk + kucuk
}



fun main(args: Array<String>) {
val dizi = intArrayOf(9,54,57,54,324,32110)
    val sonuc = array(dizi)
    println("En Buyuk Ve En Küçük Sayılar toplamı= $sonuc")
}
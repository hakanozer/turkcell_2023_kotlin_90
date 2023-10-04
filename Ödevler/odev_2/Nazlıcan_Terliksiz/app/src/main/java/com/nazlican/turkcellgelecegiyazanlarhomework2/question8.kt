package com.nazlican.turkcellgelecegiyazanlarhomework2

//parametre olarak verilen int[] deki
//en büyük ve en küçük sayının toplamını
//int olarak döndüren method yazın

fun main() {
    val list = arrayListOf(3 ,5, 7, 9, 11)
    val toplam = enBuyukEnKucukToplami(list)
    println("Dizideki en büyük ve en küçük sayının toplamı: $toplam")
}
fun enBuyukEnKucukToplami(list: ArrayList<Int>): Int {
    var enBuyuk = list[0]
    var enKucuk = list[0]

    for (sayi in list) {
        if (sayi > enBuyuk) {
            enBuyuk = sayi
        } else if (sayi < enKucuk) {
            enKucuk = sayi
        }
    }
    return enBuyuk + enKucuk
}




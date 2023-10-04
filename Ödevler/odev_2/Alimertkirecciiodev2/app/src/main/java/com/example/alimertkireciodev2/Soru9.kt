package com.example.alimertkireciodev2
//9 - parametre olarak bir int[]ve bir sayi
//alan, eğer array sayiyi içeriyorsa true,
//içermiyorsa false döndüren bir method yazin
fun parametre(dizi:IntArray,sayi:Int):Boolean{
return sayi in dizi
}



fun main(args: Array<String>) {
val sayılar= intArrayOf(3,5,7,9,11,13)
    val sayi=2
    val yapılan= parametre(sayılar,sayi)
    if (yapılan){
        println("Dizide $sayi içeriyor")
    }else
    {
        println("dizide $sayi içerilmemekte")
    }
}
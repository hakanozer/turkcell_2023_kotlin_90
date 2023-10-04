package com.example.alimertkireciodev2
fun palindrome(sayi:Int):Boolean{
val degerler=sayi.toString()
    val tersleri=degerler.reversed()
    return degerler==tersleri
}

// parametre olarak verilen int sayinin
//palindrome olup olmadığını test eden
//sonucu boolean olarak döndüren  bir method
//yazın


fun main(args: Array<String>) {
val sayi=514
    val palsay= palindrome(sayi)
    if (palsay){
        println("Bu Bir Palindrom sayıdır: $sayi")
    }else {
        println( "Palidrom sayı değildir!!")
    }
}
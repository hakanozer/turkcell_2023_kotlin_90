package com.example.alimertkireciodev2
//3 - Parametre olarak 2 int sayi alan (a,b),
//ilk sayi tek ise a/b'yi,
//ilk sayi çift ise a%b'yi double olarak
//döndüren bir method yazın
import java.lang.RuntimeException

fun ikisay(a:Int,b:Int) {
    if (a % 2 == 1) {
        var sonuc = a.toDouble() / b.toDouble()
        println(sonuc)

    } else if (b == 0) {
        throw RuntimeException()
        println("Bölecek Sayı 0 Olamaz geçersiz sayı girdiniz!!")
        //Hataların Atası!!
    } else {
        var sonuc = a % b
        println(sonuc.toDouble())
    }
}

fun main(args: Array<String>) {
var a =11
var b=4
val sonuc= ikisay(a,b)
println("İşlem Sonucu:$sonuc")
}
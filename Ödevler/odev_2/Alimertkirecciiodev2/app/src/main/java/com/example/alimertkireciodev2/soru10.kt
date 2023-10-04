package com.example.alimertkireciodev2
//10 - kullanıcıdan 4 tane int değer alan,
//ve en büyük olan değeri geri döndüren bir
//method yazın
import java.util.Scanner

fun main(args: Array<String>) {
    val scanner=Scanner(System.`in`)
    println("Lütfen 1. Değeri Giriniz")
    val deger1=scanner.nextInt()
    println("Lütfen 2. Değeri Giriniz")
    val deger2=scanner.nextInt()
    println("Lütfen 3. Değeri Giriniz")
    val deger3=scanner.nextInt()
    println("Lütfen 4. Değeri Giriniz")
    val deger4= scanner.nextInt()

    if (deger1 > deger2 && deger1 > deger3 && deger1 > deger4) {
        println("$deger1 en büyük sayıdır.")
    } else if (deger2 > deger1 && deger2 > deger3 && deger2 > deger4) {
        println("$deger2 en büyük sayıdır.")
    } else if (deger3 > deger1 && deger3 > deger2 && deger3 > deger4) {
        println("$deger3 en büyük sayıdır.")
    } else if (deger4 > deger1 && deger4 > deger2 && deger4 > deger3) {
        println("$deger4 en büyük sayıdır.")
    } else {
        println("Bu dört sayı arasında en büyük bir sayı bulunmuyor.")
    }
}


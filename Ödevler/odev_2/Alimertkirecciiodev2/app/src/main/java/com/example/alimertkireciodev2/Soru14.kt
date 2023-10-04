package com.example.alimertkireciodev2

fun main(args: Array<String>) {
    try {
        println("Lütfen 1. Sayıyı Giriniz!")
        var Birincisayi= readLine()!!.toInt()
        println("Lütfen 2. Sayıyı Giriniz!")
        var Ikincisayi= readLine()!!.toInt()
        if (Ikincisayi==0){
            println("Sayılar Sıfırdan Büyük olmak Zorunda!")
        }
        else if (Birincisayi==0){
            println("Sayılar Sıfırdan Büyük olmalı")
        }
        else
        {
            println("Hata Bulunamadı!")
        }
        var islem=Birincisayi!!.toInt()/Ikincisayi!!.toInt()
        println("İşlem Sonucu== $islem")
    }catch (ex:Exception){
        println("Hata Geçersiz değer")
    }

}
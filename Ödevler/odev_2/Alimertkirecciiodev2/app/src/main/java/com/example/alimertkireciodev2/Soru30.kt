package com.example.alimertkireciodev2

fun main(args: Array<String>) {
    try {
        println("İsminiz Giriniz")
        var isim= readLine().toString()
        println("Soyisminizi Giriniz")
        var Soyisim= readLine().toString()
        Soyisim="Kır"
        println("Yaşınızı Giriniz")
        var Yas= readLine()!!.toInt()
        println("İsminiz Giriniz")
        var Mail= readLine().toString()
       var kucult=isim.toLowerCase()
        var kuculta=Soyisim.toLowerCase()
        println("Çıktılar=$kucult$kuculta")
        if (Yas>18&&Yas<75){
            println("Yaş Aralığınız Uygundur")
        }else
        {
            println("Yaş aralığınız Uygun Değildir!")
        }
    }
    catch (ex:Exception){
            println("Hatalı Giriş")
    }


}
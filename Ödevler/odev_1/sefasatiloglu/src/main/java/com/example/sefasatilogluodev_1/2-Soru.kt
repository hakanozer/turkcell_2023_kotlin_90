package com.example.sefasatilogluodev_1

import java.util.Scanner

/*
2 - Kullanıcıya Aşağıdaki Menuyu Gösteriyorsunuz

	Menu :
	1 - F -> C
	2 - C -> F
	    Secim :

	Kullanıcı 1'i Seçerse Fahrenheit Değerini Alıyorsunuz
	Girilen Değeri Dereceye Çevirip
	x F = y C Şeklinde Ekranda Gösteriyorsunuz

	Eğer 2. Seçenek Seçildiyse, C Değerini Alıyorsunuz
	Girilen Değeri Fahrenheit'a Çevirip
	x C = y F Şeklinde Ekranda Gösteriyorsunuz

	Eğer Kullanıcı Menu Seceneginde 1,2 Dışında Bir Sayı
	Girerse Ekrana Hatalı Seçim Mesajını Bastırmalısınız


 */
fun main() {
    val donusum = SicaklikDonusumu()

    val girdi = Scanner(System.`in`)
    println("""
        Menu : 
        1 - F -> C
        2 - C -> F
        
    """)
    print("Lutfen donusturmeyi seciniz:")
    val secim = girdi.next()
    println("Seciminiz: $secim")
    if (secim == "1") {
        print("Derecenizi Giriniz:")
        val deger1 = girdi.nextDouble()
        val sonuc = donusum.donusturF(deger1)
        println("Fahrenhiet: $sonuc")
    }
    if (secim == "2") {
        print("Fahrenhiet Giriniz:")
        val deger2 = girdi.nextDouble()
        val sonuc =  donusum.donusturC(deger2)
        println("Derece: $sonuc")

    }else {
        println("Hatali tuslama yaptiniz!")
    }






}
package com.example.sefasatilogluodev_1

import java.util.Scanner

/*
1 - Kullanıcıdan 3 Kenar Değeri Alıyorsun
Bu 3 Değerden Üçgen Yapılıp Yapılamayacağını
Test Edip Sonucu Bastıracaksınız

Her 2 Kenarın Toplamı Diğer 3. Kenara Eşit/Fazlaysa
Üçgen Olur

 */

fun main() {
try {
    val girdi = Scanner(System.`in`)
    println("Birinci Kenari Giriniz:")
    val kenar1 = girdi.nextInt()
    println("Ikinci Kenari Giriniz:")
    val kenar2 = girdi.nextInt()
    println("Ucuncu Kenari Giriniz:")
    val kenar3 = girdi.nextInt()

    val u1 = Ucgen()
    u1.ucgenOl(kenar1,kenar2,kenar3)
}catch (e:Exception) {
    println("Hatali Giris! Lutfen gecerli sayi yaziniz!")
}











}




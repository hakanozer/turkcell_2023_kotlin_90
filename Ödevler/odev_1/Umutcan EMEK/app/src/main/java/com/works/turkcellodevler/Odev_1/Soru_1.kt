package com.works.turkcellodevler.Odev_1

import java.util.Scanner

/*
1 - Kullanıcıdan 3 Kenar Değeri Alıyorsun
Bu 3 Değerden Üçgen Yapılıp Yapılamayacağını
Test Edip Sonucu Bastıracaksınız

Her 2 Kenarın Toplamı Diğer 3. Kenara Eşit/Fazlaysa
Üçgen Olur
*/

fun main(args: Array<String>) {

    print("Birinci kenarı giriniz: ")
    val scanner = Scanner(System.`in`)
    val num1 = scanner.nextInt()

    print("İkinci kenarı giriniz: ")
    val scanner2 = Scanner(System.`in`)
    val num2 = scanner2.nextInt()

    print("Üçüncü kenarı giriniz: ")
    val scanner3 = Scanner(System.`in`)
    val num3 = scanner3.nextInt()

    if (num1 + num2 >= num3 && num1 + num3 >= num2 && num2 + num3 >= num1){
        println("Girdiğiniz kenar değerlerden üçgen oluşturulabilir.")
    }else{
        println("Girdiğiniz kenar değerlerden üçgen oluşturulamaz!")
    }

}
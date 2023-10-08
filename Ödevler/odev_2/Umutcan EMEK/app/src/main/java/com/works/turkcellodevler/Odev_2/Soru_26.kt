package com.works.turkcellodevler.Odev_2

import java.util.Scanner

/*
26 - Kullanıcıdan yaşını girmesini talep ederek sayı girmesini bekleyiniz.
Girilen yaşa göre kullanıcının ehliyet alabilip alamayacağını kullanıcıya bildiriniz.
Eğer kullancı ehliyet alacak yaşta değilse kaç sene
sonra ehliyet alabileceğini kullanıcıya bildiriniz.
Örnek senaryoda ehliyet alabilme yaşını 18 olarak kabul edelim ve kullanıcı, yaşını 16 olarak girsin.
Bu durumda beklenen çıktı "Maalesef ehliyet alacak yaşta değilsiniz,
2 yıl sonra ehliyet almaya hak kazanabilirsiniz!" olacaktır.
(Girilen değerin sayısal bir değer ve yaş olabilitesi kontrol edilmelidir.) (Umutcan EMEK)
 */

fun main(args: Array<String>) {

    try {
        print("Lütfen yaşınızı giriniz: ")
        val scanner = Scanner(System.`in`)
        val age = scanner.nextInt()
        val remaining = 18 - age
        if (age < 0 || age > 115){
            println("Lütfen yaşınızı doğru girdiğinizden emin olun.")
            return
        }
        if (age > 18){
            println("Tebrikler ehliyet alabilirsiniz!")
        }else{
            println("Maalesef ehliyet alacak yaşta değilsiniz, $remaining yıl sonra ehliyet almaya hak kazanabilirsiniz!")
        }
    }catch (ex: Exception){
        println("İlgili alana sadece sayısal  değer giriniz.")
    }


}
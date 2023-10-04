package com.works.odevler

import java.util.Scanner

/**
 * 26 - Kullanıcıdan yaşını girmesini talep ederek sayı girmesini bekleyiniz.
 * Girilen yaşa göre kullanıcının ehliyet alabilip alamayacağını kullanıcıya bildiriniz.
 * Eğer kullancı ehliyet alacak yaşta değilse kaç sene
 * sonra ehliyet alabileceğini kullanıcıya bildiriniz.
 * Örnek senaryoda ehliyet alabilme yaşını 18 olarak kabul edelim ve kullanıcı, yaşını 16 olarak girsin.
 * Bu durumda beklenen çıktı "Maalesef ehliyet alacak yaşta değilsiniz,
 * 2 yıl sonra ehliyet almaya hak kazanabilirsiniz!" olacaktır.
 * (Girilen değerin sayısal bir değer ve yaş olabilitesi kontrol edilmelidir.) (Umutcan EMEK)
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    try {
        println("Yaşınızı giriniz !")
        val yas = scanner.nextInt()
        var ehliyetYası=18
        var kacYılKaldı = ehliyetYası - yas
        if (yas < ehliyetYası){
            println("Maalesef ehliyet alacak yaşta değilsiniz ehliyet almanıza $kacYılKaldı yıl var")
        }else if (yas >= ehliyetYası ){
            println("Ehliyet almaya yaşınız uygun")
        }

    }catch (ex:Exception){
            println("Lütfen sayısal değer giriniz !")
    }
}
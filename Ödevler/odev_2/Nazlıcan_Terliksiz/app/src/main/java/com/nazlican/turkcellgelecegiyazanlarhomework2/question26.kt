package com.nazlican.turkcellgelecegiyazanlarhomework2

import java.util.InputMismatchException
import java.util.Scanner

//Kullanıcıdan yaşını girmesini talep ederek sayı girmesini bekleyiniz.
//Girilen yaşa göre kullanıcının ehliyet alabilip alamayacağını kullanıcıya bildiriniz.
//Eğer kullancı ehliyet alacak yaşta değilse kaç sene
//sonra ehliyet alabileceğini kullanıcıya bildiriniz.
//Örnek senaryoda ehliyet alabilme yaşını 18 olarak kabul edelim ve kullanıcı, yaşını 16 olarak girsin.
//Bu durumda beklenen çıktı "Maalesef ehliyet alacak yaşta değilsiniz,
//2 yıl sonra ehliyet almaya hak kazanabilirsiniz!" olacaktır.
//(Girilen değerin sayısal bir değer ve yaş olabilitesi kontrol edilmelidir

fun main() {
    val scanner = Scanner(System.`in`)

    try {
        print("Yaşınızı girin: ")
        val yas = scanner.nextInt()

        if (yas <= 0) {
            throw IllegalArgumentException("Geçerli bir yaş giriniz.")
        }

        val ehliyetYasi = 18

        if (yas >= ehliyetYasi) {
            println("Ehliyet alabilirsiniz.")
        } else {
            val kacYilSonraEhliyetAlabilirsiniz = ehliyetYasi - yas
            println("Maalesef ehliyet alacak yaşta değilsiniz, $kacYilSonraEhliyetAlabilirsiniz yıl sonra ehliyet almaya hak kazanabilirsiniz.")
        }

    } catch (e: InputMismatchException) {
        println("Hata: Geçerli bir yaş girişi yapmadınız.")
    } catch (e: IllegalArgumentException) {
        println("Hata: ${e.message}")
    }
}
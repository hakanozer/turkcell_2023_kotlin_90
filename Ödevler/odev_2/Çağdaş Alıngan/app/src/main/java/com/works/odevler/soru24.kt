package com.works.odevler
import java.util.Scanner
import kotlin.math.pow
/**
 * 24- Kullanıcıdan 3 basamaklı sayılar isteyiniz
 * ve bu sayılardan armstrong sayısı bulan bir algoritma
 * olusturunuz ve verilerin sayı girilmesini de Try catch
 * yapısı ile kontrolünü sağlayınız.(Kemal Çetinkaya)
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val sayilar = mutableListOf<Int>()
    try {


        for (item in 1..3) {
            print("Sayı $item girin: ")
            val sayi = scanner.nextInt()

                sayilar.add(sayi)


        }

        for (item in 0 until 3) {
            if (isArmstrongNumber(sayilar[item])) {
                println("${sayilar[item]} bir Armstrong sayısıdır.")
            } else {
                println("${sayilar[item]} bir Armstrong sayısı değildir.")
            }
        }
    }catch (ex:Exception){
        println("Lütfen tam sayı giriniz !")
    }
}






fun isArmstrongNumber(sayi: Int): Boolean {
    var toplam = 0
    var geciciSayi = sayi
    val basamakSayisi = sayi.toString().length

    while (geciciSayi != 0) {
        val rakam = geciciSayi % 10
        toplam += rakam.toDouble().pow(basamakSayisi.toDouble()).toInt()
        geciciSayi /= 10
    }

    return toplam == sayi
}

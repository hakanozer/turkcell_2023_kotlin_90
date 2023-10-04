package com.works.odevler

import java.util.Scanner

/**
 * 25- Kullanıcıdan pozitif bir tam sayı alınız ve
 * bu sayının faktöriyelini hesaplayınız. Kullanıcı metin veya
 * negatif bir tam sayı girişi yaptığında try-catch ile hata mesajları görüntüleyiniz. (Mehmet Şahin)
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Sayı giriniz")
    try {
        val sayi = scanner.nextInt()
        if (sayi > 0 ){
            val sonuc = faktoriyel(sayi)
            println("$sayi! = $sonuc")
        }else{
            println("Lütfen pozitif tam sayı giriniz")
        }


    }catch (ex:Exception){
            println("Hata ! Lütfen metin ifadesi girmeyiniz")
    }

}
fun faktoriyel(sayi : Int): Long {
    var sonuc:Long = 1
    for (item in 1..sayi){
        sonuc *= item.toLong()
    }
    return sonuc
}
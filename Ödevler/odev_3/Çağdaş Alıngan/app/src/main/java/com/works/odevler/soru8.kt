package com.works.odevler

import java.io.File
import java.util.Scanner

/**
 * #8. Kullanıcıdan Bir Klasörün Yolunu Alın.
 * O Klasör ve O Klasörün Altındaki Tüm Klasörlerde Dahil Olmak Üzere
 * (Burada Recursive Bir Method Yazmanız Gerek)
 * Toplam Boyutu Bulup Ekrana Yazdırın
 */
fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    println("Dosya yolu giriniz!")
    val dosyaYolu = scanner.nextLine()
    val dosya = File(dosyaYolu)
    if (dosya.exists()){
        val byte = klasorBoyutunuBul(dosya)
        val kiloByte = byte / 1024
        val megaByte = kiloByte / 1024
        println("Toplam boyut = $megaByte MB ")
    }
}
fun klasorBoyutunuBul(dosya:File): Long{

    var boyut:Long = 0
    if (dosya.isDirectory){
        val dosyalar = dosya.listFiles()
        for (item in dosyalar!!){
            boyut += klasorBoyutunuBul(item)
        }
    }else{
        boyut = dosya.length()
    }
    return boyut
}
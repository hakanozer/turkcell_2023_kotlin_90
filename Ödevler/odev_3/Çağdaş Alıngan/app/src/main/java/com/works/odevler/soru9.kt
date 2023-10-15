package com.works.odevler

import java.io.File
import java.util.Scanner

/**
 * #9. Kullanıcıdan Bir Kelime Alın
 * 8. Sorudaki Recursive Dosya Dolaşma Mantığıyla, Dosya Adında Kullanıcının Girmiş Olduğu Kelimeyi İçeren
 * Dosyaların;
 *
 * Arama Sonucu Kaç Dosyanın Bulunduğunu,
 * Adını,
 * Bulunduğu Klasörü
 * Boyutunu Ekrana Bastırın
 */
// 9. ve 10. soru aynı
fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    println("Kelime giriniz !")
    val kelime = scanner.nextLine()


    val dosyaYolu = File(".").absoluteFile
    val bulunanDosya = dosyaAra(dosyaYolu,kelime)

    println("sonuç : ${bulunanDosya.size} dosya bulundu !")

    for ((index,dosya) in bulunanDosya.withIndex()){
        println("Dosya ${index+1} ")
        println("Adı : ${dosya.name}")
        println("Bulunduğu klasör: ${dosya.parent}")
        println("Boyutu: ${dosya.length()} byte")
    }

}
fun dosyaAra(yol:File, kelime:String) :MutableList<File>{


    val liste = mutableListOf<File>()
    val dosyalar = yol.listFiles() ?: return liste

    for (dosya in dosyalar){
        if (dosya.isDirectory){
            liste.addAll(dosyaAra(dosya, kelime))
        }else if (dosya.name.contains(kelime, ignoreCase = true)){
            liste.add(dosya)
        }
    }
    return liste
}